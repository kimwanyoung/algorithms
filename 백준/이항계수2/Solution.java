package 백준.이항계수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new Integer[n + 1][n + 1];
        int result = binomialCoefficient(n, k);

        System.out.println(result);
    }

    // 점화식 nCk = n-1Ck-1 + n-1Ck;
    static int binomialCoefficient(int n, int k) {
        if(k == 0 || n == k) {
            return 1;
        }

        if(dp[n][k] == null) {
            dp[n][k] = binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
        }

        return dp[n][k] % 10007;
    }
}
