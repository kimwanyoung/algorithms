package 백준.단지번호붙이기;

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
		// 1. 입력 받고, 배열에 값 저장
		// 2. 전체 배열 반복문 수행하면서 0이 아닌 위치 찾기
		// 3. 만약, 현재 위치가 0이 아니고 방문된 적 없다면 bfs수행
		// 	3-1. 상하좌우 탐색하면서 0이 아니면 q.offer()
		// 4. bfs수행 후 전체 count를 List<Intger> result에 추가
		// 5. 배열 순회 끝났다면, 오름차순 정렬 후 result.size() 출력
		// 6. 전체 리스트 값들 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String[] lines = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(lines[j]);
			}
		}

		// 2
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				// 3
				if(map[i][j] != 0 && !visited[i][j]) {
					int count = bfs(i, j);
					// 4
					result.add(count);
				}
			}
		}

		// 5
		result.sort(Comparator.naturalOrder());
		System.out.println(result.size());
		// 6
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	static int bfs(int y, int x) {
		int count = 1;
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[]{y, x});
		visited[y][x] = true;
		while (!q.isEmpty()) {
			int[] current = q.poll();

			// 3-1
			for(int i = 0; i < 4; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];

				if(0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && map[ny][nx] != 0) {
					q.offer(new int[]{ny, nx});
					visited[ny][nx] = true;
					count++;
				}
			}
		}

		return count;
	}
}
