package 백준.그림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int paint = 0;
	static int maxWidth = 0;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// 연결되어있는 면적들을 모두 구하고, 각 면적중 가장 큰 면적의 넓이를 구하는 문제
		// 1. 입력받고 map 초기화
		// 2. map의 모든 칸 순회하면서 방문하지 않았으면서 칸의 값이 1인 좌표 탐색
		// 3. 조건에 만족하면 해당 칸부터 bfs수행
		//	3-1. 탐색은 상하좌우 4방향
		//	3-2. 범위를 벗어나거나, 이미 방문된 칸이거나, 다음 칸의 값이 0이면 continue
		// 	3-3. 현재 최대 넓이와 bfs종료 후 현재 넓이 중 더 큰 값으로 갱신
		// 4. bfs 수행이 끝나면 그림의 개수++
		// 5. 첫번째 줄에 개수 출력, 두번째 줄에 최대 면적 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 || visited[i][j]) continue;

				// 3
				bfs(i, j);
				// 4
				paint++;
			}
		}

		// 5
		System.out.println(paint);
		System.out.println(maxWidth);
	}

	static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		int width = 1;

		q.offer(new int[]{y, x});
		visited[y][x] = true;
		while(!q.isEmpty()) {
			int[] currentPos = q.poll();

			// 3-1
			for(int i = 0; i < 4; i++) {
				int ny = dy[i] + currentPos[0];
				int nx = dx[i] + currentPos[1];

				// 3-2
				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || map[ny][nx] == 0) continue;

				q.offer(new int[]{ny, nx});
				visited[ny][nx] = true;
				width++;
			}
		}
		// 3-3
		maxWidth = Math.max(maxWidth, width);
	}
}
