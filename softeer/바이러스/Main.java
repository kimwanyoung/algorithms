package softeer.바이러스;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long K = Long.parseLong(st.nextToken());
		long P = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());

		// 바이러스 수 계산: (K % MOD * (P^N % MOD)) % MOD
		long result = (K % MOD * modPow(P, N, MOD)) % MOD;

		System.out.println(result);
	}

	// 거듭제곱 분할 정복 (빠른 거듭제곱)
	static long modPow(long base, long exp, int mod) {
		long result = 1;
		base %= mod; // base가 mod보다 클 경우 미리 나눠서 줄이기

		while (exp > 0) {
			if (exp % 2 == 1) {  // 홀수 지수라면 결과에 base를 곱해줌
				result = (result * base) % mod;
			}
			base = (base * base) % mod; // base를 제곱
			exp /= 2;  // 지수를 절반으로 줄이기
		}
		return result;
	}
}