package 백준.결혼식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static class FriendInfo {
		int number;
		int depth;

		public FriendInfo(int number, int depth) {
			this.number = number;
			this.depth = depth;
		}
	}

	static int N, M;
	static int[] visited;
	static List<Integer>[] graph;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		// 1. bfs 탐색
		// 2. depth를 갖고 depth가 2이하일 때 result++;
		// 3. result 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new int[N + 1];
		graph = new List[N + 1];

		for(int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		bfs();

		for(int i = 1; i < visited.length; i++) {
			if(visited[i] > 0 && visited[i] <= 3) {
				result++;
			}
		}

		System.out.println(result - 1);
	}

	static void bfs() {
		Queue<FriendInfo> q = new LinkedList<>();

		q.offer(new FriendInfo(1, 1));
		visited[1] = 1;
		while(!q.isEmpty()) {
			FriendInfo current = q.poll();

			for(int next : graph[current.number]) {
				if(visited[next] == 0){
					q.offer(new FriendInfo(next, current.depth + 1));
					visited[next] = current.depth + 1;
				}

				if(visited[next] > 0 && current.depth + 1 < visited[next]) {
					q.offer(new FriendInfo(next, current.depth + 1));
					visited[next] = current.depth + 1;
				}
			}
		}
	}
}
