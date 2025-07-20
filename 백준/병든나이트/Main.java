package 백준.병든나이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 더 이상 움직일 수 없을 때 까지
		// N, M 의 범위는 2_000_000_000
		// 맨 왼쪽 아래, 방향은 오른쪽으로만 이동가능
		// 4번보다 많이 움직이면 모든 방향 사용해야함
		// 즉 방향이 제한돼있으면, M이 커도 최대 4
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int answer = 0;
		if(n == 1) answer = 1;
		if(n == 2) answer = Math.min(4, (m + 1) / 2);
		if(n >= 3 && m < 7) answer = Math.min(4, m);
		if(n >= 3 && m >= 7) answer = m - 2;

		System.out.println(answer);
	}
}
