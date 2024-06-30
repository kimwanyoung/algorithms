const input = [
    2,
    6,
    12,
]

const n = input[0];

for(let i = 1; i <= n; i++) {
    const dp = new Array(input[i] + 1).fill(0);

    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;

    for(let j = 3; j <= input[i]; j++) {
        dp[j] = dp[j - 2] + dp[j - 3];
    }
    console.log(dp[input[i] - 1]);
}