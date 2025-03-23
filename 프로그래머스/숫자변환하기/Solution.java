package 프로그래머스.숫자변환하기;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

	static class Info {
		int sum, count;

		public Info(int sum, int count) {
			this.sum = sum;
			this.count = count;
		}
	}

	int[] types = {-1, 0, 1};
	public int solution(int x, int y, int n) {
		int result = bfs(x, y, n);
		return result;
	}

	private int bfs(int x, int y, int n) {
		Queue<Info> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		q.offer(new Info(x, 0));
		visited.add(x);
		while(!q.isEmpty()) {
			Info current = q.poll();
			if(current.sum == y) {
				return current.count;
			}

			for(int i = 0; i < 3; i++) {
				int next = calculateByType(current.sum, n, types[i]);

				if(visited.contains(next) || next > y) continue;

				q.offer(new Info(next, current.count + 1));
				visited.add(next);
			}
		}
		return -1;
	}

	private int calculateByType(int sum, int n, int type) {
		if(type == -1) return sum + n;
		if(type == 0) return sum * 2;
		if(type == 1) return sum * 3;
		return -1;
	}
}
