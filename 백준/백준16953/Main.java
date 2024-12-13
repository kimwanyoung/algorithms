package 백준.백준16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		int count = 1;
		while(b < a) {
			if(b % 10 == 1) b /= 10;
			else if(b % 2 == 0) b /= 2;
			else {
				System.out.println(-1);
				return;
			}

			if(a > b) {
				System.out.println(-1);
				return;
			}
			count++;
		}

		System.out.println(count);
	}
}
