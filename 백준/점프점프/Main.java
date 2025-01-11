package 백준.점프점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static  class MazeInfo {
		int blockNumber;
		int attempt;

		public MazeInfo(int blockNumber, int attempt) {
			this.blockNumber = blockNumber;
			this.attempt = attempt;
		}
	}

	static int N;
	static int[] maze;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 미로의 길이 저장
		N = Integer.parseInt(br.readLine());
		maze = new int[N];
		visited = new boolean[N];
		// 미로의 각 칸수 저장
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			maze[i] = Integer.parseInt(st.nextToken());
		}
		// bfs진행 모든 가능한 점프 구하기
		int result = bfs();
		System.out.println(result);
	}

	static int bfs() {
		Queue<MazeInfo> queue = new LinkedList<>();
		// Queue에 현재 위치 및 depth(점프 횟수) 저장 + 방문처리
		queue.offer(new MazeInfo(0, 0));
		visited[0] = true;
		while(!queue.isEmpty()) {
			// 현재 꺼낸 칸이 미로의 마지막 칸이면 return;
			MazeInfo current = queue.poll();
			if(current.blockNumber == N - 1) {
				return current.attempt;
			}

			// 꺼낸 후 현재 위치에서 점프 가능한 칸수 더해준 후 다시 큐에 저장
			//  방문처리 되어있는지 확인, 범위 확인
			//  안되어있으면 저장 및 방문처리
			for(int i = maze[current.blockNumber]; i > 0 ; i--) {
				if(current.blockNumber + i < N && !visited[current.blockNumber + i]){
					queue.offer(new MazeInfo(current.blockNumber + i, current.attempt + 1));
					visited[current.blockNumber + i] = true;
				}
			}
		}
		// 도달할 수 없다면, -1 반환
		return -1;
	}
}
