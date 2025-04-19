package 백준.전투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class SoliderInfo {
		int y, x;
		String type;

		public SoliderInfo(int y, int x, String type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}

	static int N, M;
	static String[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new String[M][N];
		for (int i = 0; i < M; i++) {
			String currentLine = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				map[i][j] = String.valueOf(currentLine.charAt(j));
			}
		}

		List<Integer> soliderW = new ArrayList<>();
		List<Integer> soliderB = new ArrayList<>();

		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].equals("W") && !visited[i][j]) {
					int result = findClumped(i, j, "W");
					soliderW.add(result);
				}
			}
		}

		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].equals("B") && !visited[i][j]) {
					int result = findClumped(i, j, "B");
					soliderB.add(result);
				}
			}
		}

		int w = 0;
		int b = 0;
		for (int i = 0; i < soliderW.size(); i++) {
			w += soliderW.get(i) * soliderW.get(i);
		}

		for (int i = 0; i < soliderB.size(); i++) {
			b += soliderB.get(i) * soliderB.get(i);
		}

		System.out.println(w + " " + b);
	}

	static int findClumped(int y, int x, String soliderType) {
		int count = 1;
		int[] dy = {0, 0, -1, 1};
		int[] dx = {-1, 1, 0, 0};
		Queue<SoliderInfo> q = new LinkedList<>();

		q.offer(new SoliderInfo(y, x, soliderType));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			SoliderInfo current = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];

				if (ny < 0 || ny >= M || nx < 0 || nx >= N || visited[ny][nx] || !map[ny][nx].equals(soliderType))
					continue;

				q.offer(new SoliderInfo(ny, nx, soliderType));
				visited[ny][nx] = true;
				count++;
			}
		}

		return count;
	}
}
