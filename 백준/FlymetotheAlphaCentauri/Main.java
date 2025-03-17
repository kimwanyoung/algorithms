package 백준.FlymetotheAlphaCentauri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			int distance = Y - X;

			int max = (int)Math.sqrt(distance);

			if (max == Math.sqrt(distance)) {
				System.out.println(max * 2 - 1);
			} else if (distance <= max * max + max) {
				System.out.println(max * 2);
			} else {
				System.out.println(max * 2 + 1);
			}
		}
	}
}
