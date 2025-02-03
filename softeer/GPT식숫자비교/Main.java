package softeer.GPT식숫자비교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1. 입력받기
		// 2. List에 저장하기
		// 3. 만약, 소수점이 없다면 같은 수의 소수점이 있는 수보다 작기 때문에 .-1을 붙여서 같은 수 중 가장 작도록 저장
		// 4. 정렬 수행
		// 5. List 안의 수들 각각 출력 .-1을 포함한다면 제거 후 정수만 출력

		// 1
		List<String> numbers = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 2
		for(int i = 0; i < N; i++) {
			String current = br.readLine();
			// 3
			if(!current.contains(".")) {
				current += ".-1";
			}
			numbers.add(current);
		}

		// 4
		numbers.sort((a, b) -> {
			String[] splitedA = a.split("\\.");
			String[] splitedB = b.split("\\.");
			if(Integer.parseInt(splitedA[0]) == Integer.parseInt(splitedB[0])) {
				return Integer.parseInt(splitedA[1]) - Integer.parseInt(splitedB[1]);
			}
			return Integer.parseInt(splitedA[0]) - Integer.parseInt(splitedB[0]);
		});

		// 5
		for(String number : numbers) {
			if(number.contains(".-1")) {
				System.out.println(number.split(".-1")[0]);
				continue;
			}
			System.out.println(number);
		}
	}
}
