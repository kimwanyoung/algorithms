package 백준.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M;
	// 2
	static boolean[] visited = new boolean[100_001];
	static int[] operators = new int[]{-1, 1, 2};
	public static void main(String[] args) throws IOException {
		// 1. N, M 입력 받기
		// 2. 배열 초기화 크기는 100_000 (0 <= N, M <= 100_000)
		// 3. bfs 수행
		// 	3-1. 0보다 크고 100_000보다 작은 범위에서 current + 1, current - 1, current * 2 세 연산 가능
		// 4. current == M 현재 step 반환
		// 5. bfs() 결과 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splitLine = br.readLine().split(" ");
		N = Integer.parseInt(splitLine[0]);
		M = Integer.parseInt(splitLine[1]);
		// 3
		int result = bfs();
		// 5
		System.out.println(result);
	}

	static int bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[]{N, 0});
		visited[N] = true;
		while(!q.isEmpty()) {
			int[] current = q.poll();
			// 4
			if(current[0] == M) {
				return current[1];
			}

			for(int i = 0; i < 3; i++) {
				int next = 0;
				if(operators[i] == 2) {
					next = current[0] * operators[i];
				} else {
					next = current[0] + operators[i];
				}

				// 3-1
				if(0 <= next && next <= 100_000 && !visited[next]) {
					q.offer(new int[]{next, current[1] + 1});
					visited[next] = true;
				}
			}

		}
		return -1;
	}
}
