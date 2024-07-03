/**
 * [solution]
 * - dp 문제
 * - 1 => 1
 * - 2 => 2
 * - 3 => 4
 * - 4 => 7
 * ...
 * => 점화식 : d[i] = d[i - 1] + d[i - 2] + d[i - 3] (i > 3)
 */
const input = [
    "3",
    "4",
    "7",
    "10",
]

const n = Number(input[0]);
const numbers = [];

for(let i = 1; i <= n; i++) {
    numbers.push(Number(input[i]));
}

const max = Math.max(...numbers);

//dp table
const dp = new Array(max + 1).fill(0);

dp[1] = 1;
dp[2] = 2;
dp[3] = 4;

for(let i = 4 ; i <= max; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % (Number(1e9) + 9);
}

for(let i = 0; i < n; i++) {
    const current = numbers[i];
    console.log(dp[current]);
}