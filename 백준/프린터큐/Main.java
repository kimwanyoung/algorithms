package 백준.프린터큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Doc {
		int index;
		int priority;

		public Doc(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Queue<Doc> queue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int priority = Integer.parseInt(st.nextToken());
				queue.offer(new Doc(i, priority));
				pq.offer(priority); // 우선순위 트래킹용
			}

			int printCount = 0;

			while (!queue.isEmpty()) {
				Doc current = queue.poll();
				if (current.priority < pq.peek()) {
					queue.offer(current); // 뒤로 보냄
				} else {
					pq.poll(); // 출력함
					printCount++;
					if (current.index == m) {
						System.out.println(printCount);
						break;
					}
				}
			}
		}
	}
}
