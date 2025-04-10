package 프로그래머스.멀쩡한사각형;

public class Solution {
	public long solution(int w, int h) {
		long origin = (long)w * h;

		long repeat = enclideanAlgorithm(w, h);

		long wRepeat = (long) w / repeat;
		long hRepeat = (long) h / repeat;

		long removed = wRepeat + hRepeat - 1;
		return origin - removed * repeat;
	}

	private int enclideanAlgorithm(int a, int b) {
		if(b == 0) {
			return a;
		}
		return enclideanAlgorithm(b, a % b);
	}
}
