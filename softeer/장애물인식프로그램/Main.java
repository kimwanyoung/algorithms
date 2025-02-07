package softeer.장애물인식프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	static List<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// 1. map[][]을 입력받고 초기화
		// 2. 모든 칸에 대해서 bfs() 수행
		// 	2-1. 이미 방문한 적이 있거나, 장애물이 없다면(칸의 값이 0이라면) continue;
		// 3. bfs() 수행
		//	3-1. 탐색 방향은 상하좌우 4방향
		//	3-2. 범위 N을 벗어나거나 이미 방문되었거나, 다음 탐색 칸의 값이 0이면 continue,
		//	3-3. 탐색이 끝났다면 count를 result리스트에 저장
		// 4. result.size() 출력하고 오름차순 정렬된 값들을 한줄에 하나씩 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		// 2
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 2-1
				if(visited[i][j] || map[i][j] == 0) continue;

				bfs(i, j);
			}
		}

		// 4
		System.out.println(result.size());

		result.sort(Comparator.naturalOrder());
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	// 3
	static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		int count = 1;

		q.offer(new int[]{y, x});
		visited[y][x] = true;
		while(!q.isEmpty()) {
			int[] current = q.poll();

			// 3-1
			for(int i = 0; i < 4; i++) {
				int ny = dy[i] + current[0];
				int nx = dx[i] + current[1];

				// 3-2
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || map[ny][nx] == 0) continue;

				q.offer(new int[]{ny, nx});
				visited[ny][nx] = true;
				count++;
			}
		}

		// 3-3
		result.add(count);
	}
}
