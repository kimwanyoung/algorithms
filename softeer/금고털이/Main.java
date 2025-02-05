package softeer.금고털이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
	public static void main(String[] args) throws IOException {
		// 더이상 가방에 넣을 수 없을 때까지 더한 후 남은 무게 만큼 나머지 값어치를 더해준다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int bag = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {weight, value});
		}

		int price = 0;
		while(!pq.isEmpty() || bag != 0) {
			int[] product = pq.poll();
			if(bag - product[0] < 0) {
				price += (bag * product[1]);
				bag = 0;
				continue;
			}
			bag -= product[0];
			price += (product[0] * product[1]);
			System.out.println(bag);
		}

		System.out.println(price);
	}
}
