const input = [
    6,
    6,
    10,
    13,
    9,
    8,
    1,
];

const [n, ...wines] = input;

const dp = new Array(n + 1).fill(0);

d[0] = wines[0]; // i = 0 일 때 최대값은 첫번째 (i번째까지만을 고려했을 때 최대값)
dp[1] = wines[0] + wines[1]; // i = 1 일 때의 최대값은 첫번째 두번째 (i번째까지만을 고려했을 때 최대값)
dp[2] = Math.max(wines[0] + wines[1], wines[1] + wines[2], wines[0] + wines[2]); // 0, 1, 2에서 2까지만을 가정 그러므로 [0 1][1 2][0 2]중 최대값 존재 (i번째까지만을 고려했을 때 최대값)

for(let i = 3; i <= n; i++) {
    dp[i] = dp[i - 1];
    dp[i] = Math.max(dp[i], wines[i] + dp[i - 2]); // 현재 고른 것과 직전은 고르지 않은 경우
    dp[i] = Math.max(dp[i], wines[i] + wines[i - 1] + dp[i - 3]); //현재 고른 양과 연속3개가 되지 않는 지금까지 총 합을 비교
}

console.log(dp[n - 1]);