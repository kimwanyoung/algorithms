package 백준.안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int safeArea = 0;
	static int maxSafeArea = 0;
	static int maxHeight = 0;

	public static void main(String[] args) throws IOException {
		// 1. 입력받고 배열 채운다.
		// 2. 배열의 모든칸 순회
		//	2-1. 모든 높이 구하기
		//	2-2. 최대 높이 구하기
		// 3. 현재 높이와 같거나 작은 칸이 존재하면 해당 칸 부터 bfs() 수행
		// 	3-1. 만약, 제공된 높이보다 작거나, 이미 방문한 칸이면 continue;
		//	3-2. bfs() 수행은 상하좌우 4방향으로 수행
		//	3-3. 만약, 범위를 넘어가거나, 이미 방문됐거나, 칸의 수가 높이보다 작다면 continue
		// 4. bfs 수행 후 safeArea++;
		//	4-1. 현재 safeArea와 maxSafeArea 비교 후 최대값으로 교체
		// 5. safeArea출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int currentHeight = Integer.parseInt(st.nextToken());
				map[i][j] = currentHeight;
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		// 2
		for (int k = 0; k <= maxHeight; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 3-1
					if (map[i][j] <= k || visited[i][j])
						continue;
					// 3
					bfs(i, j, k);
					// 4
					safeArea++;
				}
			}
			// 4-1
			visited = new boolean[N][N];
			maxSafeArea = Math.max(maxSafeArea, safeArea);
			safeArea = 0;
		}

		System.out.println(maxSafeArea);
	}

	static void bfs(int y, int x, int ch) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {y, x});
		visited[y][x] = true;
		while (!q.isEmpty()) {
			int[] current = q.poll();

			// 3-2
			for (int i = 0; i < 4; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];

				// 3-3
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || map[ny][nx] <= ch)
					continue;

				q.offer(new int[] {ny, nx});
				visited[ny][nx] = true;
			}
		}
	}
}
