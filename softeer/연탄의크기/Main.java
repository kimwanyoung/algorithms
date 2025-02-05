package softeer.연탄의크기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] houses;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		houses = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for(int i = 2; i <= 100; i++) {
			int temp = 0;
			for(int j = 0; j < N; j++) {
				if(houses[j] % i == 0) {
					temp++;
				}
			}
			max = Math.max(max, temp);
		}

		System.out.println(max);
	}
}
