package 백준.서버실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] servers;
	static long total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		servers = new int[n][n];

		int max = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int serverAmount = Integer.parseInt(st.nextToken());
				servers[i][j] = serverAmount;
				total += serverAmount;
				max = Math.max(max, serverAmount);
			}
		}

		if(total == 0) {
			System.out.println(0);
			return;
		}

		int minutes = 0;
		int start = 1;
		int end = max;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(isHalf(mid)) {
				minutes = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(minutes);
	}

	static boolean isHalf(int mid) {
		long count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				count += Math.min(servers[i][j], mid);
			}
		}

		return (double) count / (double) total >= 0.5;
	}
}
