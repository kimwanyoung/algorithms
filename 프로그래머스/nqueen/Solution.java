package 프로그래머스.nqueen;

public class Solution {

	int count = 0;
	int[] arr;
	public int solution(int n) {
		arr = new int[n];

		nqueen(0, n);
		return count;
	}

	void nqueen(int depth, int n) {
		if(depth == n) {
			count++;
			return;
		}
		for(int i = 0; i < n; i++) {
			arr[depth] = i;
			if(movable(depth)) {
				nqueen(depth + 1, n);
			}
		}
	}

	boolean movable(int col) {
		for(int i = 0; i < col; i++) {
			if(arr[col] == arr[i]) return false;
			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
		}
		return true;
	}
}
