package 프로그래머스.양궁대회;

import java.util.Arrays;

public class Solution {

	private static int maxDiff = 0;
	private static int[] bestCombination = {-1};

	public static int[] solution(int n, int[] info) {
		int[] ryan = new int[11];
		dfs(n, info, ryan, 0);
		return bestCombination;
	}

	private static void dfs(int arrowsLeft, int[] apeach, int[] ryan, int index) {
		if (index == 11) {
			if (arrowsLeft > 0) {
				ryan[10] += arrowsLeft;
			}
			int ryanScore = 0;
			int apeachScore = 0;
			for (int i = 0; i < 11; i++) {
				if (ryan[i] > apeach[i]) {
					ryanScore += 10 - i;
				} else if (apeach[i] > 0) {
					apeachScore += 10 - i;
				}
			}
			int diff = ryanScore - apeachScore;
			if (diff > maxDiff) {
				maxDiff = diff;
				bestCombination = Arrays.copyOf(ryan, 11);
			} else if (diff == maxDiff) {
				for (int i = 10; i >= 0; i--) {
					if (ryan[i] > bestCombination[i]) {
						bestCombination = Arrays.copyOf(ryan, 11);
						break;
					} else if (ryan[i] < bestCombination[i]) {
						break;
					}
				}
			}
			if (arrowsLeft > 0) {
				ryan[10] -= arrowsLeft;
			}
			return;
		}

		if (arrowsLeft > apeach[index]) {
			ryan[index] = apeach[index] + 1;
			dfs(arrowsLeft - ryan[index], apeach, ryan, index + 1);
			ryan[index] = 0;
		}
		dfs(arrowsLeft, apeach, ryan, index + 1);
	}
}
