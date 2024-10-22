package 백준.돌게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		/*
			돌 0 : 창영
			돌 1 : 상근
			돌 2 : 창영
			돌 3 : 상근
			... dp[N] = (n % 2 == 1) // true : SK, false : CY
		 */
		if(N % 2 == 1) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}
}
