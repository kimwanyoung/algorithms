package 백준.달팽이;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	static int[][] board;
	static int N, target;
	static int targetX, targetY;

	// 상, 우, 하, 좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());

		board = new int[N][N];

		int x = N / 2;
		int y = N / 2;
		int num = 1;
		board[x][y] = num;

		if (num == target) {
			targetX = x + 1;
			targetY = y + 1;
		}

		int length = 1;
		int dir = 0;

		while (num < N * N) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < length; j++) {
					x += dx[dir];
					y += dy[dir];

					if (x < 0 || y < 0 || x >= N || y >= N) continue;

					num++;
					board[x][y] = num;

					if (num == target) {
						targetX = x + 1;
						targetY = y + 1;
					}
				}
				dir = (dir + 1) % 4;
			}
			length++;
		}

		// 출력 (BufferedWriter로 한 번에)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(board[i][j] + " ");
			}
			bw.newLine();
		}
		bw.write(targetX + " " + targetY + "\n");
		bw.flush();
		bw.close();
	}
}
