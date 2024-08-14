package 백준.동물원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 9901;
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1; // 기저 사례

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
    }
}
