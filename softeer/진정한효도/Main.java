package softeer.진정한효도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] ground = new int[3][3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Integer.MAX_VALUE;

		// 최소와 최대를 기준으로 비용 계산
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, getAdjustmentCost(ground[i][0], ground[i][1], ground[i][2])); // 가로 줄
			min = Math.min(min, getAdjustmentCost(ground[0][i], ground[1][i], ground[2][i])); // 세로 줄
		}

		System.out.println(min);
	}

	private static int getAdjustmentCost(int a, int b, int c) {
		int minValue = Math.min(a, Math.min(b, c));
		int maxValue = Math.max(a, Math.max(b, c));

		int costToLower = (a - minValue) + (b - minValue) + (c - minValue);
		int costToHeighten = (maxValue - a) + (maxValue - b) + (maxValue - c);

		return Math.min(costToLower, costToHeighten);
	}
}