package 프로그래머스.하노이의탑;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<int[]> list = new ArrayList<>();
	public int[][] solution(int n) {
		hanoi(n, 1, 3, 2);
		return list.toArray(new int[0][0]);
	}

	 void hanoi(int amount, int from, int to, int via) {
		int[] move = {from, to};

		if(amount == 1) {
			list.add(move);
		} else {
			hanoi(amount - 1, from, via, to);
			list.add(move);
			hanoi(amount - 1, via, to, from);
		}
	}
}
