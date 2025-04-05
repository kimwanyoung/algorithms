package 프로그래머스.연속된부분수열의합;

public class Solution {
	public int[] solution(int[] sequence, int k) {
		// 1. 투포인터 알고리즘
		// 2. start, end 0번 인덱스에서 시작
		// 3. start, end의 합을 누적해서 더해준다.
		// 4. 만약, 합이 크거나 같다면, 길이를 저장해주고 sum-=sequence[start], start + 1
		// 5. 만약, 합이 작다면 sum+=sequence[end], end + 1
		// 6. 만약, 합이 같고 현재 최소길이보다 작다면 값 갱신

		int start = 0;
		int end = 0;
		int currentLength = Integer.MAX_VALUE;
		long sum = 0;
		int[] answer = {-1, -1};
		while(true) {
			if(sum >= k) {
				if(sum == k && end - start < currentLength) {
					currentLength = end - start;
					answer[0] = start;
					answer[1] = end - 1;
				}
				sum -= sequence[start++];
			} else {
				if(end >= sequence.length) {
					break;
				}
				sum += sequence[end++];
			}
		}
		return answer;
	}
}