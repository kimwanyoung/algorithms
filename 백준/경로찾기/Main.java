package 백준.경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 999_999;
	static int N;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		// 	1-1. 0은 이동할 수 없는 곳으로 INF로 저장
		// 2. 모든 노드에서 다른 모든 노드의 경로를 구하는 문제이므로 플로이드-워셜
		// 3. 플로이드 워셜 수행 후 INF이면, 0출력 그 외 1출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if(v == 0) {
					graph[i][j] = INF;
					continue;
				}
				graph[i][j] = 1;
			}
		}

		// 2
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		// 3
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] >= INF) {
					sb.append(0).append(" ");
					continue;
				}
				sb.append(1).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
