package softeer.나무공격;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// 1. 입력 받고 N, M, map[][]초기화
		// 2. 공격 횟수만큼 해당 범위에 존재하는 환경 파괴범 0으로 업데이트
		// 	2-1. 파괴범이 존재했다면, break;
		// 3. 전체 map 순회하면서 파괴범 수 찾기;
		// 4. 남은 파괴범 수 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2
		for(int k = 0; k < 2; k++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			for(int i = start; i <= end; i++) {
				for(int j = 0; j < M; j++) {
					// 2-1
					if(map[i][j] == 1) {
						map[i][j] = 0;
						break;
					}
				}
			}
		}

		// 3
		int destroyer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) destroyer++;
			}
		}

		// 4
		System.out.println(destroyer);
	}
}
