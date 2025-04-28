package 백준.태권왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int s, t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testcase = Integer.parseInt(br.readLine());
		while (testcase > 0) {
			st = new StringTokenizer(br.readLine());

			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			bfs();

			testcase--;
		}
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {s, 0, t});

		while (!q.isEmpty()) {
			int[] current = q.poll();

			if (current[0] == current[2]) {
				System.out.println(current[1]);
				return;
			}

			if (current[0] <= current[2]) {
				q.offer(new int[] {current[0] + current[0], current[1] + 1, current[2] + 3});
				q.offer(new int[] {current[0] + 1, current[1] + 1, current[2]});
			}
		}
	}
}
