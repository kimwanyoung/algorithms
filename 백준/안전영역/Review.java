package 백준.안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Review {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int max = 0;
	static int maxHeight = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int currentHeight = Integer.parseInt(st.nextToken());
				map[i][j] = currentHeight;
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		for(int h = 0; h <= maxHeight; h++){
			int count = 0;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(map[i][j] > h && !visited[i][j]){
						bfs(i, j, h);
						count++;
					}
				}
			}
			visited = new boolean[N][N];
			max = Math.max(max, count);
		}

		System.out.println(max);
	}

	static void bfs(int x, int y, int h) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[]{x, y});
		visited[x][y] = true;

		while(!queue.isEmpty()){
			int[] current = queue.poll();

			for(int i = 0; i < 4; i++){
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] > h){
					visited[nx][ny] = true;
					queue.add(new int[]{nx, ny});
				}
			}
		}
	}
}