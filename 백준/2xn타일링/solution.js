/**
 * [solution]
 * - 2 x 1 = 1
 * - 2 x 2 = 2
 * - 2 x 3 = 3
 * - 2 x 4 = 5
 * ....
 * => 점화식 : dp[i] = dp[i - 1] + dp[i - 2];
 */

const input = ["1000"];

const n = Number(input[0]);

const dp = new Array(n + 1).fill(0);
dp[1] = 1;
dp[2] = 2;

for(let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
}

console.log(dp[n]);