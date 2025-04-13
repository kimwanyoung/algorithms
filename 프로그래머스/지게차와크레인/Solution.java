package 프로그래머스.지게차와크레인;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	int[] dy = {0, 0, -1, 1};
	int[] dx = {1, -1, 0, 0};
	boolean[][] visited;
	String[][] map;
	int n, m;

	public int solution(String[] storage, String[] requests) {
		int answer = 0;

		/*
			0. 매 request마다 bfs() 수행하면서, 접근 가능한 칸 갱신
			1. 만약, request[i]가 한개라면, 접근가능한지 여부 판별 후 출고
			2. 만약 크레인이라면, 그냥 제거
		 */

		map = new String[storage.length + 2][storage[0].length() + 2];
		n = storage.length;
		m = storage[0].length();

		for (int i = 0; i < n + 2; i++) {
			Arrays.fill(map[i], "-1");
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i + 1][j + 1] = String.valueOf(storage[i].charAt(j));
			}
		}

		for (int i = 0; i < requests.length; i++) {
			bfs(map); // 접근 가능한 칸 갱신
			if (requests[i].length() == 1) {
				remove(map, requests[i]);
			}
			if (requests[i].length() == 2) {
				removeAll(map, String.valueOf(requests[i].charAt(0)));
			}
		}

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (map[i][j].equals("-1")) continue;
				answer++;
			}
		}
		return answer;
	}

	private void bfs(String[][] map) {
		visited = new boolean[n + 2][m + 2];
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Node current = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];

				if (nx < 0 || ny < 0 || nx >= m+2 || ny >= n+2) continue;
				if (visited[ny][nx] || !map[ny][nx].equals("-1")) continue;

				visited[ny][nx] = true;
				q.offer(new Node(ny, nx));
			}
		}
	}

	private void remove(String[][] map, String target) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j].equals(target)) {
					if(accessible(i, j)) {
						map[i][j] = "-1";
					}
				}
			}
		}
	}

	private void removeAll(String[][] map, String target) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j].equals(target)) {
					map[i][j] = "-1";
				}
			}
		}
	}

	private boolean accessible(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(visited[ny][nx]) return true;
		}

		return false;
	}
}

