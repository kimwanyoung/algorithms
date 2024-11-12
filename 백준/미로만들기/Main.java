package 백준.미로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Point {
		int y, x, depth, changeCount;

		public Point(int y, int x, int depth, int changeCount) {
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.changeCount = changeCount;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		bfs(map, n);
	}

	static void bfs(int[][] map, int n) {
		// 다익스트라 우선순위 큐, depth가 짧은 순으로 정렬
		Queue<Point> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.changeCount));
		boolean[][] check = new boolean[n][n];
		q.add(new Point(0, 0, 0, 0));
		check[0][0] = true;

		int answer = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int px = p.x;
			int py = p.y;
			int depth = p.depth;
			int changeCount = p.changeCount;
			if (px == n - 1 && py == n - 1) {
				answer = changeCount;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1 || check[ny][nx]) continue;
				check[ny][nx] = true;
				if (map[ny][nx] == 1) {
					q.add(new Point(ny, nx, depth + 1, changeCount));
				}
				// 검은 방일 경우 changeCount++;
				if(map[ny][nx] == 0){
					q.add(new Point(ny, nx, depth + 1, changeCount + 1));
				}
			}
		}
		System.out.println(answer);
	}
}