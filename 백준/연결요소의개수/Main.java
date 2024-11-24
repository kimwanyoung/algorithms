package 백준.연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static List<Integer>[] graph;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// 1. 1번 노드부터 N번 노드까지 dfs수행
		// 1-1. 이미 방문된 노드면 continue;
		// 1-2. 처음 방문하는 노드면 count++;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		for(int i = 1; i < n + 1; i++) {
			if(visited[i]) continue;
			dfs(i);
			count++;
		}

		System.out.println(count);
	}

	public static void dfs(int currentNode) {
		if(visited[currentNode]) return;

		visited[currentNode] = true;
		for(int nextNode : graph[currentNode]) {
			if(visited[nextNode]) continue;
			dfs(nextNode);
		}
	}
}
