package 백준.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Position {
		int x, y, count;

		public Position(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");
		N = Integer.parseInt(firstLine[0]);
		M = Integer.parseInt(firstLine[1]);
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}



		int result = bfs();
		System.out.println(result);
	}

	static int bfs() {
		Queue<Position> q = new LinkedList<>();

		// 	2. 0,0 에서 탐색 시작 -> N - 1, M - 1까지 탐색하는 bfs수행
		q.offer(new Position(0, 0, 1));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Position current = q.poll();
			if(current.y == N - 1 && current.x == M - 1) {
				return current.count;
			}

			for(int i = 0; i < 4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];

				// 	3. 만약 인접 4방향 이동중 N, M 범위를 넘어가면 continue
				// 	4. 만약 인접 이동 방향의 칸의 값이 0이면 continue
				// 	5. 현재 위치가 (N - 1, M - 1)이라면 return count;
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == 0) continue;

				q.offer(new Position(nx, ny, current.count + 1));
				visited[ny][nx] = true;
			}
		}

		return -1;
	}
}
