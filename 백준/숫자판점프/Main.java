package 백준.숫자판점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static String[][] map = new String[5][5];
	static Set<String> visited = new HashSet<>();
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		// 숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.
		// 1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 5; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 0; j < 5; j++) {
				 map[i][j] = st.nextToken();
			 }
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dfs(i, j, map[i][j]);
			}
		}
		// 3. Set.size 출력
		System.out.println(visited.size());
	}

	// 2. dfs 수행하면서 현재 조합된 문자열 Set 자료구조에 저장
	// 2-1. 6자리가 된다면, set에 저장
	static void dfs(int y, int x, String current) {
		if(current.length() == 6) {
			visited.add(current);
			return;
		}

		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
				dfs(ny, nx, current + map[ny][nx]);
			}
		}
	}
}
