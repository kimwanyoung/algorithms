package 백준.친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static final int INF = 999_999;
	public static void main(String[] args) throws IOException {
		/*
		지민이는 세계에서 가장 유명한 사람이 누구인지 궁금해졌다.
		가장 유명한 사람을 구하는 방법은 각 사람의 2-친구를 구하면 된다.
		어떤 사람 A가 또다른 사람 B의 2-친구가 되기 위해선, 두 사람이 친구이거나, A와 친구이고, B와 친구인 C가 존재해야 된다.
		여기서 가장 유명한 사람은 2-친구의 수가 가장 많은 사람이다. 가장 유명한 사람의 2-친구의 수를 출력하는 프로그램을 작성하시오.
		A와 B가 친구면, B와 A도 친구이고, A와 A는 친구가 아니다.
		 */
		// 1. 모든 사람의 2-친구의 수를 구한 후 최댓값을 구하는 문제
		// 2. 모든 경우의 최단 경로를 구하기 위해선 플로이드-워셜 적용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] splitLine = line.split("");
			for(int j = 0; j < N; j++) {
				int cost = splitLine[j].equals("N") ? INF : 1;
				graph[i][j] = cost;
			}
		}

		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int cost = graph[i][k] + graph[k][j];
					graph[i][j] = Math.min(graph[i][j], cost);
				}
			}
		}

		int[] friendCounts = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i != j && graph[i][j] <= 2) friendCounts[i]++;
			}
		}

		int max = 0;
		for(int i = 0; i < N; i++) {
			if(friendCounts[i] > max) max = friendCounts[i];
		}

		System.out.println(max);
	}
}
