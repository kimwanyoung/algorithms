package 프로그래머스.미로탈출;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static class Node {
		int y, x;
		int count;

		public Node(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}

	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};

	static int maxY;
	static int maxX;
	static boolean[][] visited;
	static String[][] copyMaps;

	public static void main(String[] args) {
		int result = solution(new String[]{"SOOOL", "XXXXX", "OOOOO", "OXXXX", "OOOOE"});
		System.out.println(result);
	}
	public static int solution(String[] maps) {
		int answer = 0;

		maxY = maps.length;
		maxX = maps[0].length();
		visited = new boolean[maxY][maxX];
		copyMaps = new String[maxY][maxX];

		int leverY = 0;
		int leverX = 0;

		int startY = 0;
		int startX = 0;
		for(int i = 0; i < maxY; i++) {
			String[] split = maps[i].split("");
			for(int j = 0; j < maxX; j++) {
				copyMaps[i][j] = split[j];
				if(split[j].equals("S")) {
					startY = i;
					startX = j;
				}
				if(split[j].equals("L")) {
					leverY = i;
					leverX = j;
				}
			}
		}

		int leverCount = bfs(startY, startX, "L");
		if(leverCount == -1) return -1;

		visited = new boolean[maxY][maxX];
		int exitCount = bfs(leverY, leverX, "E");
		if(exitCount == -1) return -1;

		return leverCount + exitCount;
	}

	public static int bfs(int y, int x, String goal) {
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(y, x, 0));
		visited[y][x] = true;
		while(!q.isEmpty()) {
			Node current = q.poll();
			if(copyMaps[current.y][current.x].equals(goal)) {
				return current.count;
			}

			for(int i = 0; i < 4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];
				if(validateRange(ny, nx) && !visited[ny][nx] && !copyMaps[ny][nx].equals("X")){
					q.offer(new Node(ny, nx, current.count + 1));
					visited[ny][nx] = true;
				}
			}
		}

		return -1;
	}

	public static boolean validateRange(int y, int x) {
		return 0 <= y && y < maxY && 0 <= x && x < maxX;
	}
}
