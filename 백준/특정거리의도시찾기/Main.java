package 백준.특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;
	static List<Integer> results = new ArrayList<>();
	static boolean[] visited;

	static int N, M, K, X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}

		bfs();
		results.sort(Comparator.naturalOrder());

		if(results.isEmpty()) {
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int result : results) {
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		visited[X] = true;
		q.offer(new int[]{X, 0});
		while(!q.isEmpty()) {
			int[] current = q.poll();
			if(current[1] == K) {
				results.add(current[0]);
			}

			for(int nextCity : graph[current[0]]) {
				if(!visited[nextCity]) {
					visited[nextCity] = true;
					q.offer(new int[]{nextCity, current[1] + 1});
				}
			}
		}
	}
}
