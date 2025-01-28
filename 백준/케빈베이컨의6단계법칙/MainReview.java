package 백준.케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainReview {

	static final int INF = 999_999;
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// 모든 사람의 케빈-베이컨 수를 구하고, 가장 수가 적은 사람을 구하는 문제
		// 즉, 모든 사람에 대한 값을 구해야함 -> 플로이드 워셜
		// 1. 입력받고 친구 수 만큼 map INF으로 초기화
		// 2. 관계가 존재하는 번호는 1로 변경
		// 3. 플로이드 워셜 수행
		// 4. 모든 사람에 대한 케빈-베이컨 수를 더하고, 작은 사람 번호를 갱신
		// 5. 가장 작은 수를 가진 사람 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for(int i = 0 ; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				map[i][j] = INF;
			}
		}

		// 2
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[b][a] = 1;
		}

		// 3
		for(int k = 1; k <= N; k++) {
			for(int a = 1; a <= N; a++) {
				for(int b = 1; b <= N; b++) {
					map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
				}
			}
		}

		// 4
		int minimumKevinNumber = INF;
		int current = 0;
		for(int i = 1; i <= N; i++) {
			int temp = 0;
			for(int j = 1; j <= N; j++) {
				temp += map[i][j];
			}
			if(temp <= minimumKevinNumber) {
				if(temp == minimumKevinNumber) {
					current = Math.min(current, i);
				}
				if(temp < minimumKevinNumber) {
					current = i;
				}
				minimumKevinNumber = temp;
			}
		}

		// 5
		System.out.println(current);
	}
}
