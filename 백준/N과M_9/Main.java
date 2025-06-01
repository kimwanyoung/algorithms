package 백준.N과M_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		dfs(0);
	}

	static void dfs(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}


		int before = 0;
		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}

			if(before != arr[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				before = arr[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
