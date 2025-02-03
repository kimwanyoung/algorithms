package softeer.CPTI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		// 2. 각 CPTI를 정수로 변환 후 배열에 저장
		// 3. 현재 CPTI와 동일한 값이 있었는지 확인 (pairCount 증가)
		// 4. 1비트 차이가 나는 CPTI가 있었는지 확인 (pairCount 증가)
		// 5. 2비트 차이가 나는 CPTI가 있었는지 확인 (pairCount 증가)
		// 6. 현재 CPTI를 해시맵에 저장하여 다음 비교에 활용
		// 7. 모든 사람을 검사한 후 pairCount 출력

		// 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 2
		int[] cptiArray = new int[N];
		HashMap<Integer, Integer> cptiCount = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String cpti = br.readLine();
			int value = Integer.parseInt(cpti, 2); // 2진수 → 정수 변환
			cptiArray[i] = value;
		}

		int pairCount = 0;

		for (int i = 0; i < N; i++) {
			int currentCPTI = cptiArray[i];

			// 3
			pairCount += cptiCount.getOrDefault(currentCPTI, 0);

			// 4
			for (int j = 0; j < M; j++) {
				int oneBitDiff = currentCPTI ^ (1 << j);
				pairCount += cptiCount.getOrDefault(oneBitDiff, 0);
			}

			// 5
			for (int j = 0; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					int twoBitDiff = currentCPTI ^ (1 << j) ^ (1 << k);
					pairCount += cptiCount.getOrDefault(twoBitDiff, 0);
				}
			}

			// 6
			cptiCount.put(currentCPTI, cptiCount.getOrDefault(currentCPTI, 0) + 1);
		}

		// 7
		System.out.println(pairCount);
	}
}
