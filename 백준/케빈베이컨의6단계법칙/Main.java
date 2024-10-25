package 백준.케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static final int INF = 999999999;

	public static void main(String[] args) throws IOException {
		// 모든 사람의 케빈 베이컨 수를 구한 후 가장 작은 사람의 번호 반환
		// 플로이드 워셜
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], INF);
			dp[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[a][b] = 1;
			dp[b][a] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k][b]);
				}
			}
		}

		int temp = INF;
		int index = 0;
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = 1; j <= n; j++) {
				sum += dp[i][j];
			}

			if(temp > sum) {
				temp = sum;
				index = i;
			}
			if(temp == sum) {
				index = Math.min(index, i);
			}
		}

		System.out.println(index);
	}
}
