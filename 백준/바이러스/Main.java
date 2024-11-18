package 백준.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static List<Integer>[] lists;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// - 1번 컴퓨터와 연결돼 있는 컴퓨터의 개수 구하기
		// 1. bfs를 수행하여 큐에 들어갈 때마다 count++;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int computerAmount = Integer.parseInt(br.readLine());
		int pairAmount = Integer.parseInt(br.readLine());

		lists = new List[computerAmount + 1];
		visited = new boolean[computerAmount + 1];
		for(int i = 1; i < computerAmount + 1; i++) {
			lists[i] = new ArrayList<>();
		}

		for(int i = 0; i < pairAmount; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			lists[a].add(b);
			lists[b].add(a);
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		int count = 0;
		Queue<Integer> q = new LinkedList<>();

		q.offer(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int currentComputer = q.poll();

			for(int nextComputer : lists[currentComputer]) {
				if(!visited[nextComputer]) {
					q.offer(nextComputer);
					visited[nextComputer] = true;
					count++;
				}
			}
		}

		return count;
	}
}
