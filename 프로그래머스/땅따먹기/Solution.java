package 프로그래머스.땅따먹기;

public class Solution {

	int solution(int[][] land) {
		int answer = 0;

		int[][] dp = new int[land.length + 1][4];

		for (int i = 1; i <= land.length; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (k == j) {
						continue;
					}

					dp[i][j] = Math.max(dp[i][j], land[i - 1][j] + dp[i - 1][k]);

					answer = Math.max(answer, dp[i][j]);
				}
			}
		}

		return answer;
	}
}
