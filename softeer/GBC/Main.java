package softeer.GBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M	 = Integer.parseInt(st.nextToken());

		int[][] actual = new int[N][2];
		int[][] test = new int[M][2];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			actual[i][0] = Integer.parseInt(st.nextToken());
			actual[i][1] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			test[i][0] = Integer.parseInt(st.nextToken());
			test[i][1] = Integer.parseInt(st.nextToken());
		}

		int step = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			int actualDist = actual[i][0];
			int actualSpeed = actual[i][1];

			while(true) {
				int testDist = test[step][0];
				int testSpeed = test[step][1];
				max = Math.max(testSpeed - actualSpeed, max);

				if(testDist > actualDist) {
					test[step][0] -= actualDist;
					break;
				 } else if(testDist < actualDist) {
					actualDist -= testDist;
					step++;
				} else if(testDist == actualDist) {
					test[step][0] -= actualDist;
					step++;
					break;
				}
			}
		}

		System.out.println(max);
	}
}
