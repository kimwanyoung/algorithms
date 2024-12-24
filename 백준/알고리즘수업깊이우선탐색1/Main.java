package 백준.알고리즘수업깊이우선탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static List<Integer>[] graph;
	static int[] visited;
	static int current = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		for(int i = 1; i < N + 1; i++) {
			graph[i].sort(Comparator.naturalOrder());
		}

		dfs(R);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N + 1; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int startNode) {
		visited[startNode] = current++;
		for(int next : graph[startNode]) {
			if(visited[next] == 0) {
				dfs(next);
			}
		}
	}
}
