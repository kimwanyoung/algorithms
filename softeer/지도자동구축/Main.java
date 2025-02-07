package softeer.지도자동구축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1 <= N <= 15, 각 모든 경우의 값을 미리 저장하고 dp[N]의 값 출력
		// 점화식 : dp[0] = 4, dp[1] = 9, dp[2] = 25.... (Math.sqrt(dp[n - 1]) + Math.sqrt(dp[n - 1]) - 1) * (Math.sqrt(dp[n]) + Math.sqrt(dp[n]) - 1)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[16];

		dp[0] = 4;
		dp[1] = 9;
		dp[2] = 25;

		for(int i = 3; i <= 15; i++) {
			double v = Math.sqrt(dp[i - 1]) + (Math.sqrt(dp[i - 1]) - 1);
			dp[i] = (int)(v * v);
		}

		System.out.println(dp[N]);
	}
}
