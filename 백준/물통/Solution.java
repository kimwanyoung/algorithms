package 백준.물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

	static int[] max;
	static boolean[][] visited;
	static Set<Integer> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		max = new int[3];
		visited = new boolean[201][201];
		answer = new TreeSet<>();

		for(int i = 0; i < 3; i++) {
			max[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, max[2]);

		answer.forEach((num) -> System.out.print(num + " "));
	}

	static void dfs(int a, int b, int c) {
		if(visited[a][b]) return;

		if(a == 0) answer.add(c);
		visited[a][b] = true;

		// 0 - 1
		if(a + b > max[1]) {
			dfs(a + b - max[1], max[1], c);
		} else {
			dfs(0, a + b, c);
		}

		// 0 - 2
		if(a + c > max[2]) {
			dfs(a + c - max[2], b, max[2]);
		} else {
			dfs(0, b, a + c);
		}

		// 1 - 2
		if(b + c > max[2]) {
			dfs(a, b + c - max[2], max[2]);
		} else {
			dfs(a, 0, b + c);
		}

		// 1 - 0
		if(a + b > max[0]) {
			dfs(max[0], a + b - max[0], c);
		} else {
			dfs(a + b, 0, c);
		}

		// 2 - 1
		if(b + c > max[1]) {
			dfs(a, max[1], b + c - max[1]);
		} else {
			dfs(a, b + c, 0);
		}

		// 2 - 0
		if(a + c > max[0]) {
			dfs(max[0], b, a + c - max[0]);
		} else {
			dfs(a + c, b, 0);
		}
	}
}
