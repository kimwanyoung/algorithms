package 프로그래머스.리코쳇로봇;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	static class Position {
		int x;
		int y;
		int cost;

		public Position(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	int width, height;
	int[] start, goal;
	boolean[][] visited;

	public boolean isValid(int x, int y, String[] board) {
		if (x < 0 || y < 0 || x >= height || y >= width)
			return false;
		if (board[x].charAt(y) == 'D')
			return false;
		return true;
	}

	public int bfs(String[] board) {

		Queue<Position> q = new LinkedList<>();
		q.add(new Position(start[0], start[1], 0));
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			Position top = q.poll();
			int x = top.x;
			int y = top.y;
			int cost = top.cost;

			if (x == goal[0] && y == goal[1]) {
				return cost;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (!isValid(nx, ny, board))
					continue;

				while (true) {
					nx += dx[i];
					ny += dy[i];

					if (!isValid(nx, ny, board)) {
						nx -= dx[i];
						ny -= dy[i];
						break;
					}
				}

				if (visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				q.add(new Position(nx, ny, cost + 1));
			}
		}

		return -1;
	}

	public int solution(String[] board) {
		int answer = 0;
		height = board.length;
		width = board[0].length();

		visited = new boolean[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i].charAt(j) == 'R') {
					start = new int[] {i, j};
				} else if (board[i].charAt(j) == 'G') {
					goal = new int[] {i, j};
				}
			}
		}

		return bfs(board);
	}

}