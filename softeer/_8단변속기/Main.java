package softeer._8단변속기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1. 입력받은 1 ~ 8까지의 수를 리스트에 저장
		// 2. 오름차순, 내림차순 정렬한 값들을 각각 ascending, descending에 저장
		// 3. origin 과 ascending, descending 각각 비교 같으면 출력
		// 4. 둘 다 아니라면 mixed 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<String> origin = new ArrayList<>();
		List<String> ascending = new ArrayList<>();
		List<String> descending = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			String current = st.nextToken();
			origin.add(current);
			ascending.add(current);
			descending.add(current);
		}

		ascending.sort(Comparator.naturalOrder());
		descending.sort(Comparator.reverseOrder());

		String originString = origin.toString();
		String ascendingString = ascending.toString();
		String descendingString = descending.toString();

		if(originString.equals(ascendingString)) {
			System.out.println("ascending");
			return;
		}

		if(originString.equals(descendingString)) {
			System.out.println("descending");
			return;
		}

		System.out.println("mixed");
	}
}
