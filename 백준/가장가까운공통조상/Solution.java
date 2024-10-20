package 백준.가장가까운공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		while(t > 0) {
			int nodeCount = Integer.parseInt(br.readLine());
			List<Integer>[] tree = new ArrayList[nodeCount + 1];
			int[] visited = new int[nodeCount + 1];

			for(int i = 0; i < nodeCount + 1; i++) {
				tree[i] = new ArrayList<>();
			}

			for(int i = 0; i < nodeCount - 1; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				tree[b].add(a);
			}

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dfs(tree, visited, a, 1);
			int parent = dfs(tree, visited, b, 2);
			result.append(parent).append("\n");
			t--;
		}

		System.out.println(result);
	}

	static int dfs(List<Integer>[] tree, int[] visited, int current, int sequence) {
		if((visited[current] != 0 && visited[current] != sequence) || tree[current].isEmpty()) {
			return current;
		}

		visited[current] = sequence;
		return dfs(tree, visited, tree[current].get(0), sequence);
	}
}
