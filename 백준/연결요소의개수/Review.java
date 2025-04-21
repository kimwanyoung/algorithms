package 백준.연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Review {

	static List<Integer>[] graph;
	static Set<Integer> visited = new HashSet<>();
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(visited.contains(i)) continue;

			dfs(i);
			count++;
		}

		System.out.println(count);
	}

	static void dfs(int node) {
		visited.add(node);

		for(int next: graph[node]) {
			if(visited.contains(next)) continue;

			dfs(next);
		}
	}
}
