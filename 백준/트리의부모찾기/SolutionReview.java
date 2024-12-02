package 백준.트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SolutionReview {

	static int N;
	static int[] parents;
	static List<Integer>[] tree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// 1. 1번 노드부터 모든 모드 bfs탐색
		// 2. next노드 q에 넣을 때 currentNode를 parents[next]에 저장
		// 3. bfs 끝나면 parents[2]부터 한줄에 하나씩 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		tree = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for(int i = 1; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}

		bfs();

		StringBuilder sb = new StringBuilder();
		for(int i = 2; i < parents.length; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		q.offer(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int currentNode = q.poll();

			for(int nextNode : tree[currentNode]) {
				if(!visited[nextNode] && parents[nextNode] == 0) {
					visited[nextNode] = true;
					parents[nextNode] = currentNode;
					q.offer(nextNode);
				}
			}
		}
	}
}
