package 백준.쉬운최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class PositionInfo {
		int y, x, distance;

		public PositionInfo(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
	}

	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	static boolean[][] visited;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// 1. 입력받고 map[N][M] 초기화
		// 2. map[][]의 모든 칸을 순회하면서 bfs() 수행
		//	2-1. map[i][j]가 0이면 continue
		//	2-2. 도달할 수 없는 곳이면 -1반환
		//	2-3. 매번 visited초기화
		// 3. 가장 먼저 목표지점에 도달한 횟수 반환
		// 4. bfs()의 반환값 map[i][j]에 저장
		// 5. map[][] 전체 출력
		// -----> 메모리 초과
		// 1. 입력 받고 map[][]초기화
		// 2. 목표 지점부터 역방향으로 모든 칸 순회
		// 3. bfs() 수행하면서 다음 칸 = 현재칸 +1
		// 4. map[][] 전체 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		visited = new boolean[N][M];

		int goalY = 0, goalX = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					goalY = i;
					goalX = j;
				}
			}
		}

		bfs(goalY, goalX);

		// 4
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					sb.append("-1").append(" ");
				} else {
					sb.append(copyMap[i][j]).append(" ");
				}

			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int y, int x) {
		Queue<PositionInfo> q = new LinkedList<>();

		q.offer(new PositionInfo(y, x, 0));
		copyMap[y][x] = 0;
		visited[y][x] = true;
		while(!q.isEmpty()) {
			PositionInfo currentPos = q.poll();

			for(int i = 0; i < 4; i++) {
				int ny = dy[i] + currentPos.y;
				int nx = dx[i] + currentPos.x;

				if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || map[ny][nx] == 0) continue;

				q.offer(new PositionInfo(ny, nx, currentPos.distance + 1));
				copyMap[ny][nx] = copyMap[currentPos.y][currentPos.x] + 1;
				visited[ny][nx] = true;
			}
		}
	}
}
