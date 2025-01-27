package 백준.영역구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> result = new ArrayList<>();
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		// 2. 입력받은 M, N 크기의 배열 초기화
		// 3. K개수만큼 반복문 돌면서, 제공된 꼭지점 사이의 면적을 1로 저장
		// 4. 배열의 모든 칸 bfs() 수행
		// 	4-1. 현재 진입하려는 칸이 1이거나 이미 방문된 칸이라면 continue
		//	4-2. bfs() 진행 방향은 상하좌우 4방향
		//	4-3. 다음 순회하려는 칸이 이미 방문되었거나, 범위를 벗어나거나, 1이라면 continue
		//	4-4. bfs()수행 끝나면 List<Integer> result에 저장
		// 5. result 정렬
		// 6. result.size() 출력
		// 7. 오름차순 정렬된 순서대로 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 2
		map = new int[M][N];
		visited = new boolean[M][N];

		// 3
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());

			for(int l = ly; l < ry; l++) {
				for(int j = lx; j < rx; j++) {
					map[l][j] = 1;
				}
			}
		}

		// 4
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				// 4-1
				if(map[i][j] == 1 || visited[i][j]) continue;

				// 4-4
				int width = bfs(i, j);
				result.add(width);
			}
		}

		// 5
		result.sort(Comparator.naturalOrder());
		// 6
		int size = result.size();
		System.out.println(size);
		// 7
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			sb.append(result.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	static int bfs(int y , int x) {
		Queue<int[]> q = new LinkedList<>();

		int count = 1;
		q.offer(new int[]{y, x});
		visited[y][x] = true;
		while(!q.isEmpty()) {
			int[] current = q.poll();

			// 4-2
			for(int i = 0; i < 4; i++) {
				int ny = dy[i] + current[0];
				int nx = dx[i] + current[1];

				// 4-3
				if(ny < 0 || ny >= M || nx < 0 || nx >= N || map[ny][nx] == 1 || visited[ny][nx]) continue;

				q.offer(new int[]{ny, nx});
				visited[ny][nx] = true;
				count++;
			}
		}
		return count;
	}
}
