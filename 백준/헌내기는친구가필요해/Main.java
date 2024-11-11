package 백준.헌내기는친구가필요해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static String[][] map;
	private static boolean[][] visited;
	private static int N, M;
	private static int[] dy = {0, 0, -1, 1};
	private static int[] dx = {1, -1, 0, 0};
	private static int answer = 0;

	static class Position {
		int y, x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		// 1. N, M 입력 받아서 map 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		visited = new boolean[N][M];

		// 2. I의 위치 값 찾아서 저장
		Position currentI = new Position(0, 0);
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			map[i] = split;
			for (int j = 0; j < M; j++) {
				if (split[j].equals("I")) {
					currentI = new Position(i, j);
				}
			}
		}

		// 3. 상하좌우 bfs 수행하면서, 이동한 위치에 'P'가 존재하면 answer++;
		// 	3-1. 벽으로는 이동 불가.
		//	3-2. 범위 밖으로 이동 불가.
		bfs(currentI);

		// 4. 모든 이동가능한 지점 탐색 완료 후 answer 출력
		//	4-1. answer > 0 ? answer : "TT" 출력
		System.out.println(answer > 0 ? answer : "TT");
	}

	private static void bfs(Position position) {
		Queue<Position> q = new LinkedList<>();

		q.offer(position);
		visited[position.y][position.x] = true;
		while (!q.isEmpty()) {
			Position currentPosition = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = currentPosition.y + dy[i];
				int nx = currentPosition.x + dx[i];

				if (validateRange(ny, nx) && !visited[ny][nx]) {
					if (map[ny][nx].equals("P")) answer++;
					q.offer(new Position(ny, nx));
					visited[ny][nx] = true;
				}
			}
		}
	}

	private static boolean validateRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M && !map[y][x].equals("X");
	}
}
