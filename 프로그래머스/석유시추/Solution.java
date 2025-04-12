package 프로그래머스.석유시추;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

	int[] oils;
	public int solution(int[][] land) {
		boolean[][] visited = new boolean[land.length][land[0].length];
		oils = new int[land[0].length];

		for(int i = 0; i < land.length; i++) {
			for(int j = 0; j < land[0].length; j++) {
				if(!visited[i][j] && land[i][j] != 0) {
					// 1
					bfs(land, visited, i, j);
				}
			}
		}

		return Arrays.stream(oils).max().getAsInt();
	}

	private void bfs(int[][] land, boolean[][] visited, int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		Set<Integer> idx = new HashSet<>();

		int[] dy = {0, 0, -1, 1};
		int[] dx = {-1, 1, 0, 0};

		int size = 1;
		visited[y][x] = true;
		q.offer(new int[]{y, x});

		while(!q.isEmpty()) {
			int[] current = q.poll();
			idx.add(current[1]);

			for(int i = 0; i < 4; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];

				if(isMovable(ny, nx, land.length, land[0].length) && !visited[ny][nx] && land[ny][nx] == 1) {
					// 2.
					q.offer(new int[]{ny, nx});
					visited[ny][nx] = true;
					size++;
				}
			}
		}

		for(int i: idx) {
			oils[i] += size;
		}
	}

	private boolean isMovable(int y, int x, int maxY, int maxX) {
		return 0 <= y && y < maxY && 0 <= x && x < maxX;
	}
}
