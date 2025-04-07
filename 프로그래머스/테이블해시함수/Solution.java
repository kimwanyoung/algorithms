package 프로그래머스.테이블해시함수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static int solution(int[][] data, int col, int row_begin, int row_end) {
		/*
			1. data를 col번째 컬럼 기준으로 오름차순 정렬 수행한다.
			2. 만약, 같은 값이 존재한다면, 0번 인덱스를 기준으로 내림차순 정렬을한다.
			3. (S_i는 row_begin ~ row_end까지) S_i를 각 컬럼을 i로 나눈 나머지들의 합을 구한다.
			4. 전체 결과에 대해서 xor연산을 한 결과를 반환.
		 */

		Arrays.sort(data, (a, b) -> {
			if(a[col - 1] == b[col - 1]) {
				return b[0] - a[0];
			}
			return a[col - 1] - b[col - 1];
		});

		List<Integer> numbers = new ArrayList<>();
		for(int i = row_begin - 1; i < row_end; i++) {
			int s = 0;
			for(int j = 0; j < data[i].length; j++) {
				s += data[i][j] % (i+1);
			}
			numbers.add(s);
		}

		int answer = 0;
		for(int number : numbers) {
			answer ^= number;
		}
		return answer;
	}
}
