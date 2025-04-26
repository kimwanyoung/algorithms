package 백준.텀프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] students;
	static boolean[] visited, done;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testcase = Integer.parseInt(br.readLine());

		while(testcase > 0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			students = new int[n];
			visited = new boolean[n];
			done = new boolean[n];
			for(int i = 0; i < n; i++) {
				students[i] = Integer.parseInt(st.nextToken()) - 1;
			}

			for(int i = 0; i < n; i++) {
				if(!done[i]) {
					dfs(students[i]);
				}
			}

			System.out.println(n - count);
			count = 0;
			testcase--;
		}
	}

	static void dfs(int student) {
		if(done[student]) return;
		if(visited[student]) {
			done[student] = true;
			count++;
		}

		visited[student] = true;
		dfs(students[student]);
		done[student] = true;
	}
}
