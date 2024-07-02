const input = [
    "3",
    "26 40 83",
    "49 60 57",
    "13 89 99",
]

const n = Number(input[0]);

const arr = [];
const dp = [];

for(let i = 0 ; i < n; i++) {
    let [r, g, b] = input[i + 1].split(" ").map(Number);
    dp.push(new Array(3).fill(1000000));
    arr.push([r, g, b]);
}

dp[0][0] = arr[0][0];
dp[0][1] = arr[0][1];
dp[0][2] = arr[0][2];

for(let i = 1; i < n; i++) {
    for(let j = 0; j < 3; j++) {
        for(let k = 0; k < 3; k++) {
            if(j !== k) dp[i][j] = Math.min(dp[i][j], arr[i][j] + dp[i - 1][k]);
        }
    }
}

console.log(Math.min(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]));