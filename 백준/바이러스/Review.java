package 백준.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Review {

	static List<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int computer = Integer.parseInt(br.readLine());
		int linked = Integer.parseInt(br.readLine());

		graph = new ArrayList[computer + 1];
		visited = new boolean[computer + 1];
		for(int i = 1; i <= computer; i++) {
			graph[i] = new ArrayList<>();
		}

		 for(int i = 0 ; i < linked; i++) {
			 st = new StringTokenizer(br.readLine());

			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());

			 graph[a].add(b);
			 graph[b].add(a);
		 }

		 dfs(1);

		 int count = 0;
		 for(boolean v : visited) {
			 if(v) count++;
		 }

		System.out.println(count - 1);
	}

	static void dfs(int node) {
		visited[node] = true;

		for(int next: graph[node]) {
			if(visited[next]) continue;

			dfs(next);
		}
	}
}
