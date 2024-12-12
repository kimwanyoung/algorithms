package 백준.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;
	static boolean[] visited;
	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int total = Integer.parseInt(st.nextToken());
		graph = new ArrayList[total + 1];
		visited = new boolean[total + 1];
		for (int i = 1; i < total + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {A, 0});
		visited[A] = true;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			if(current[0] == B) return current[1];

			for(int next: graph[current[0]]) {
				if(visited[next]) continue;

				q.offer(new int[]{next, current[1] + 1});
				visited[next] = true;
			}
		}

		return -1;
	}
}
