package 백준.나이트의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][] direction = new int[][]{{-1, -2}, {-2, -1}, {1, 2}, {2, 1}, {-1, 2}, {1, -2}, {-2, 1}, {2, -1}};
	public static void main(String[] args) throws IOException {
		// 1. 테스트 케이스 개수 입력 받기
		// 2. 각 테스트 케이스마다 체스 판의 길이가 다르기 때문에 테스트 케이스 개수만큼 배열을 초기화 해주어야함
		// 3. 배열 visited[][] 선언 후 초기화
		// 4. bfs 수행 후 현재 위치가 목표위치와 같으면 횟수 반환
		//	4-1. bfs 수행 중 이동할 수 있는 방향은 8가지 {-1, -2}, {-2, -1}, {1, 2}, {2, 1}, {-1, 2}, {1, -2}, {-2, 1}, {2, -1}
		// 5. bfs 수행 완료 후 이동횟수 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		// 2
		for(int i = 0; i < testCase; i++) {
			int width = Integer.parseInt(br.readLine());
			String[] stringCurrentPos = br.readLine().split(" ");
			int currentPosY = Integer.parseInt(stringCurrentPos[0]);
			int currentPosX = Integer.parseInt(stringCurrentPos[1]);
			String[] stringGoalPos = br.readLine().split(" ");
			int goalPosY = Integer.parseInt(stringGoalPos[0]);
			int goalPosX = Integer.parseInt(stringGoalPos[1]);

			// 3
			boolean[][] visited = new boolean[width][width];
			// 4
			int moveCount = bfs(visited, currentPosY, currentPosX, goalPosY, goalPosX);
			// 5
			System.out.println(moveCount);
		}
	}

	static int bfs(boolean[][] visited, int y, int x, int gy, int gx) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[]{y, x, 0});
		visited[y][x] = true;
		while(!q.isEmpty()) {
			int[] currentPos = q.poll();
			if(currentPos[0] == gy && currentPos[1] == gx) {
				return currentPos[2];
			}

			// 4-1
			for(int i = 0; i < 8; i++) {
				int ny = currentPos[0] + direction[i][0];
				int nx = currentPos[1] + direction[i][1];

				if(ny < 0 || ny >= visited.length || nx < 0 || nx >= visited.length || visited[ny][nx]) continue;

				q.offer(new int[]{ny, nx, currentPos[2] + 1});
				visited[ny][nx] = true;
			}
		}

		return -1;
	}
}
