package 프로그래머스.가장큰정사각형찾기;

public class Solution {

	public static void main(String[] args) {
		int answer = solution(new int[][]{{0,1,1,1}, {0,1,1, 1}});
		System.out.println(answer);
	}
	public static int solution(int [][]board) {
		// 1. dp를 통해 가장 긴 길이를 구하기
		// 2. 만약, 이전 값이 0이라면, 직선이 아니기 때문에 continue
		// 3. max * max 반환

		int max = 0;
		int[][] dp = new int[board.length + 1][board[0].length + 1];
		for(int i = 1; i <= board.length; i++) {
			for(int j = 1; j <= board[0].length; j++) {
				if(board[i - 1][j - 1] != 0) {
					int min = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
					dp[i][j] = min + 1;
					max = Math.max(max, min + 1);
				}
			}
		}

		return max * max;
	}
}
