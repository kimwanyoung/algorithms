package 백준.파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Town implements Comparable<Town> {
		int end, dist;

		public Town(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Town o) {
			return dist - o.dist;
		}
	}

	static final int MAX = 99999999;
	static int N, M, X;
	static List<List<Town>> towns = new ArrayList<>();
	static List<List<Town>> reverseTowns = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 도로 수
		X = Integer.parseInt(st.nextToken()); // 파티 장소

		for(int i = 0; i <= N; i++) {
			towns.add(new ArrayList<>());
			reverseTowns.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			towns.get(start).add(new Town(end, dist));
			reverseTowns.get(end).add(new Town(start, dist));
		}

		int[] dist = dijkstra(towns);
		int[] reverseDist = dijkstra(reverseTowns);

		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Math.max(result, dist[i] + reverseDist[i]);
		}

		System.out.println(result);
	}

	public static int[] dijkstra(List<List<Town>> tl) {
		Queue<Town> pq = new PriorityQueue<>();
		pq.offer(new Town(X, 0));

		boolean[] visited = new boolean[N + 1];
		int[] distances = new int[N + 1];
		Arrays.fill(distances, MAX);
		distances[X] = 0;

		while(!pq.isEmpty()) {
			Town current = pq.poll();
			int end = current.end;

			if(!visited[end]) {
				visited[end] = true;

				for(Town town : tl.get(end)) {
					if(!visited[town.end] && distances[town.end] > distances[end] + town.dist) {
						distances[town.end] = distances[end] + town.dist;
						pq.offer(new Town(town.end, distances[town.end]));
					}
				}
			}
		}
		return distances;
	}
}
