package 백준.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dy = {0, 0, 1, -1};
	private static int[] dx = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testcase = Integer.parseInt(br.readLine());
		while (testcase > 0) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(m, n, i, j);
						count++;
					}
				}
			}

			System.out.println(count);
			testcase--;
		}
	}

	public static void bfs(int m, int n, int cy, int cx) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {cy, cx});
		visited[cy][cx] = true;
		while (!q.isEmpty()) {
			int[] currentPos = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = currentPos[0] + dy[i];
				int nx = currentPos[1] + dx[i];

				if (0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] == 1 && !visited[ny][nx]) {
					q.offer(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
	}
}
