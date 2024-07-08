const input = ["10", "1 1 2 3 5 8 13 21 34 55",]

const n = Number(input[0]);
const cards = input[1].split(" ").map(Number);
let dp = [0, ...cards];

for (let i = 2; i <= n; i++) {
    for (let j = 1; j < i; j++) {
        dp[i] = Math.min(dp[i], (dp[i - j] + dp[j]));
    }
}

console.log(dp[n]);