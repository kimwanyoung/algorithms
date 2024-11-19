package 백준.dfs와bfs;

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

	private static int n;
	private static int m;
	private static List<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		// 단순히 bfs, dfs적용 하는 문제
		// 1번째 줄에 dfs 결과 출력
		// 2번째 줄에 bfs 결과 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		graph = new List[n + 1];

		for(int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		for(int i = 1; i < n + 1; i++) {
			graph[i].sort(Comparator.comparingInt(a -> a));
		}
		List<Integer> dfs = dfs(start, new ArrayList<>());
		List<Integer> bfs = bfs(start);

		StringBuilder dfsResult = new StringBuilder();
		StringBuilder bfsResult = new StringBuilder();
		for(int i = 0; i < dfs.size(); i++) {
			dfsResult.append(dfs.get(i)).append(" ");
			bfsResult.append(bfs.get(i)).append(" ");
		}

		System.out.println(dfsResult);
		System.out.println(bfsResult);
	}

	public static List<Integer> dfs(int current, List<Integer> history) {
		history.add(current);

		if(history.size() == n) {
			return history;
		}

		for(int next : graph[current]) {
			if(history.contains(next)) continue;
			dfs(next, history);
		}

		return history;
	}

	public static List<Integer> bfs(int current) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> history = new ArrayList<>();
		boolean[] visited = new boolean[n + 1];

		q.offer(current);
		visited[current] = true;
		history.add(current);
		while (!q.isEmpty()) {
			int currentNode = q.poll();

			for (int next : graph[currentNode]) {
				if(visited[next]) continue;
				q.offer(next);
				visited[next] = true;
				history.add(next);
			}
		}

		return history;
	}
}
