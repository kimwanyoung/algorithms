package 백준.스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] move = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		move[0] = Integer.parseInt(st.nextToken());
		move[1] = -Integer.parseInt(st.nextToken());

		int count = bfs(f, s, g);

		if (count == -1) {
			System.out.println("use the stairs");
			return;
		}

		System.out.println(count);
	}

	static int bfs(int f, int s, int g) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[f + 1];

		q.offer(new int[] {s, 0});
		visited[s] = true;
		while (!q.isEmpty()) {
			int[] current = q.poll();

			if (current[0] == g) {
				return current[1];
			}

			for (int i = 0; i < 2; i++) {
				int next = current[0] + move[i];

				if (next < 1 || next > f || visited[next])
					continue;

				q.offer(new int[] {next, current[1] + 1});
				visited[next] = true;
			}
		}

		return -1;
	}
}
