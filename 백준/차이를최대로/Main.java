package 백준.차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr, selected;
	static boolean[] visited;
	static int max;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		selected = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		back(0);
		System.out.println(max);
	}

	static void back(int depth) {
		if(depth == n) {
			int sum = 0;
			for(int i = 0; i < n - 1; i++) {
				sum += Math.abs(selected[i] - selected[i + 1]);
			}
			max = Math.max(max, sum);
			return;
		}

		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[depth] = arr[i];
				back(depth + 1);
				visited[i] = false;
			}
		}
	}
}
