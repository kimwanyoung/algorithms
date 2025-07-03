package 백준.숫자정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int M;
	static int maxLength;
	static int[][] square;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		square = new int[N][M];

		maxLength = Math.min(N, M);

		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				square[i][j] = Integer.parseInt(line[j]);
			}
		}

		int current = maxLength;
		while(current != 1) {
			boolean checked = false;
			for(int i = 0; i <= N - current; i++) {
				for(int j = 0; j <= M - current; j++) {
					if(findSquare(i, j, current - 1)) {
						checked = true;
						break;
					}
				}

				if(checked) break;
			}
			if(checked) break;

			current--;
		}

		System.out.println(current * current);
	}

	static boolean findSquare(int y, int x, int current) {
		return (square[y][x] == square[y + current][x] && square[y][x] == square[y][x+current] &&
			square[y][x] == square[y+current][x+current]);
	}
}
