package softeer.RecoveringTheRegion;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int[][] section;
	static boolean[][] visited;
	static int N;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		// 1. 크기 입력받기, map[][], section[][] 초기화
		// 2. 모든 칸 순회하면서, 구역 나누기
		// 	2-1. 각 칸마다 bfs() 수행
		// 	2-2. Set을 이용하여 중복되지 않는 수만 set에 담고 이미 존재하는 수는 담지 않는다.
		//	2-3. 탐색 방향은 상하좌우 4방향
		// 	2-4. bfs()가 종료되면 현재 구역++
		// 3. section[][] 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		section = new int[N][N];
		visited = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2
		int sectionNumber = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, sectionNumber);
					sectionNumber++;
				}
			}
		}

		// 3
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(section[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void bfs(int y, int x, int sectionNumber) {
		Queue<int[]> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();

		q.offer(new int[]{y, x});
		set.add(map[y][x]);
		section[y][x] = sectionNumber;
		visited[y][x] = true;
		while(!q.isEmpty()) {
			int[] current = q.poll();

			for(int i = 0; i < 4; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];

				if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || set.contains(map[ny][nx])) continue;

				q.offer(new int[]{ny, nx});
				set.add(map[ny][nx]);
				section[ny][nx] = sectionNumber;
				visited[ny][nx] = true;
			}
		}
	}
}
