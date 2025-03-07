package 백준.장군;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
첫 번째 줄에는 상의 위치를 의미하는 정수 R1, C1이 주어진다.

두 번째 줄에는 왕의 위치를 의미하는 정수 R2, C2가 주어진다. 장기판에서 Ri (0 ≤ Ri ≤ 9)는 행을, Ci (0 ≤ Ci ≤ 8)는 열을 의미한다.

왕은 항상 궁성에 자리 잡고 있으며, 상과 왕의 위치는 겹치지 않는다.
 */
public class Main {
	static int[][] pos = {{0, 0}, {0, 0}};

	static int[][] map = new int[10][9];
	static boolean[][] visited = new boolean[10][9];
	static int[] dy = {-2, 2, 3, 3, 2, -2, -3, -3};
	static int[] dx = {-3, -3, -2, 2, 3, 3, 2, -2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}

		map[pos[1][0]][pos[1][1]] = 1;

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {pos[0][0], pos[0][1], 0});
		visited[pos[0][0]][pos[0][1]] = true;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			if (current[0] == pos[1][0] && current[1] == pos[1][1]) {
				return current[2];
			}

			for (int i = 0; i < 8; i++) {
				int nr = dy[i] + current[0];
				int nc = dx[i] + current[1];

				if (nr > 9 || nr < 0 || nc > 8 || nc < 0 || visited[nr][nc])
					continue;

				boolean flag = false;
				int y = dy[i] < 0 ? -1 : 1;
				int x = dx[i] < 0 ? -1 : 1;
				if(Math.abs(dy[i]) > Math.abs(dx[i])) {
				   	int temp = current[0] + y;

					if(map[temp][current[1]] != 0) {
						continue;
					}

					if(map[temp + y][current[1] + x] != 0) {
						flag = true;
					}

				} else {
					int temp = current[1] + x;

					if(map[current[0]][temp] != 0) {
						continue;
					}

					if(map[current[0] + y][temp + x] != 0) {
						flag = true;
					}
				}

				if (flag) continue;

				q.offer(new int[] {nr, nc, current[2] + 1});
				visited[nr][nc] = true;
			}
		}
		return -1;
	}
}

