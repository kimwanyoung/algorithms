/**
 * [solution]
 * - n개의 물건, k의 최대 무게
 * - 0 ~ n까지 각 최대 무게를 구하고 k의 무게와 같거나 작은 무게의 가치를 구한다.
 */

const input = [
    "4 7",
    "6 13",
    "4 8",
    "3 6",
    "5 12",
]

const [N, K] = input[0].split(" ").map(Number);
const dp = Array.from(Array(N + 1), () => new Array(K + 1).fill(0));

for (let i = 1; i < N + 1; i++) {
    const [W, V] = input[i].split(" ").map(Number);
    for (let j = 1; j <= K; j++) {
        if (j - W >= 0) dp[i][j] = Math.max(dp[i - 1][j - W] + V, dp[i - 1][j]);
        else dp[i][j] = dp[i - 1][j];
    }
}

console.log(dp[N][K]);
