/**
 * [solution]
 * dp문제, 점화식 찾아서 해결 가능
 *
 * 1 => 1
 * 2 => 2
 * 3 => 3
 * 4 => 0011, 1100, 0000, 1001, 1100, 1111 => 5
 * - 점화식 : d[n] = d[n - 1] + d[n - 2] (n > 3)
 * - d[n]을 15746으로 나눈 나머지를 출력
 */

const input = ["4"];

const n = Number(input[0]);

const dp = new Array(n + 1).fill(0);

dp[1] = 1;
dp[2] = 2;

for(let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
}

console.log(dp[n]);