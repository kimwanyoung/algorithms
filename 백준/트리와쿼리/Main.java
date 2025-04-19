package 백준.트리와쿼리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, R, Q;
	static int[] qArr, cnt;
	static List<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		cnt = new int[N + 1];
		tree = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
		for(int i = 1 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		qArr = new int[Q];
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			qArr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(R, -1);
		for(int i: qArr) {
			System.out.println(cnt[i]);
		}
	}

	static void dfs(int current, int prev) {
		cnt[current] = 1;
		for(int next : tree[current]) {
			if(next == prev) continue;
			dfs(next, current);
			cnt[current] += cnt[next];
		}
	}
}
