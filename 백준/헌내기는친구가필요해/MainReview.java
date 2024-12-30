package 백준.헌내기는친구가필요해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainReview {

	static int N, M;
	static String[][] map;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	static int startX;
	static int startY;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new String[N][M];
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = line[j];
				if(map[i][j].equals("I")) {
					startY = i;
					startX = j;
				}
			}
		}

		bfs();

		if(answer == 0) {
			System.out.println("TT");
			return;
		}
		System.out.println(answer);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[]{startY, startX});
		map[startY][startX] = "X";
		while(!q.isEmpty()){
			int[] current = q.poll();

			for(int i = 0; i < 4; i++) {
				int nextY = current[0] + dy[i];
				int nextX = current[1] + dx[i];

				if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !map[nextY][nextX].equals("X")) {
					if(map[nextY][nextX].equals("P")) {
						answer++;
					}
					q.offer(new int[]{nextY, nextX});
					map[nextY][nextX] = "X";
				}
			}
		}
	}
}
