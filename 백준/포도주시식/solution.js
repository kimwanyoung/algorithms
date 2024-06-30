const input = [
    6,
    6,
    10,
    13,
    9,
    8,
    1,
]

const [n, ...wines] = input;

const dp = new Array(n).fill(0);

dp[0] = wines[0];
dp[1] = wines[0] + wines[1];
dp[2] = Math.max(wines[0] + wines[1], wines[0] + wines[2], wines[1] + wines[2]);

for(let i = 3; i < n; i++) {
    dp[i] = dp[i - 1];
    dp[i] = Math.max(dp[i], wines[i] + dp[i - 2]);
    dp[i] = Math.max(dp[i], wines[i] + wines[i - 1] + dp[i - 3]);
}

console.log(dp[n - 1]);
