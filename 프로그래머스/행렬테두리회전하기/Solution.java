package 프로그래머스.행렬테두리회전하기;

public class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] maps = new int[rows][columns];
		int[][] copyMaps = new int[rows][columns];

		int number = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				copyMaps[i][j] = number;
				maps[i][j] = number++;
			}
		}

		int answerIdx = 0;
		for(int[] query : queries) {
			int x1 = query[0] - 1;
			int y1 = query[1] - 1;
			int x2 = query[2] - 1;
			int y2 = query[3] - 1;

			int minValue = 10001;
			for(int i = y1 + 1; i <= y2; i++) {
				minValue = Math.min(minValue, maps[x1][i]);
				maps[x1][i] = copyMaps[x1][i - 1];
			}

			for(int i = x1 + 1; i <= x2; i++) {
				minValue = Math.min(minValue, maps[i][y2]);
				maps[i][y2] = copyMaps[i - 1][y2];
			}

			for(int i = y2 - 1; i >= y1; i--) {
				minValue = Math.min(minValue, maps[x2][i]);
				maps[x2][i] = copyMaps[x2][i + 1];
			}

			for(int i = x2 - 1; i >= x1; i--) {
				minValue = Math.min(minValue, maps[i][y1]);
				maps[i][y1] = copyMaps[i + 1][y1];
			}

			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < columns; j++) {
					copyMaps[i][j] = maps[i][j];
				}
			}
			answer[answerIdx++] = minValue;
		}
		return answer;
	}
}
