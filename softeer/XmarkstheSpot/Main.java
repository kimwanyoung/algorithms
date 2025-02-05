package softeer.XmarkstheSpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			String second = st.nextToken();

			String upperFirst = first.toUpperCase();
			int x = upperFirst.indexOf("X");
			result.append(second.toUpperCase().charAt(x));
		}

		System.out.println(result);
	}
}
