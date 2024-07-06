const input = [
    "7",
    "15 11 4 8 5 2 4",
]

// LIS : 가장 긴 증가하는 부분 수열
const n = Number(input[0]);
const soldiers = input[1].split(" ").map(Number);

const dp = new Array(n).fill(1);

soldiers.reverse();
for(let i = 0; i < n; i++) {
    for(let j = 0; j < i; j++) {
        if(soldiers[j] < soldiers[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1); // 각 원소를 확인해서 증가하는 부분에서 1씩 더해준다.
        }
    }
}

console.log(n - Math.max(...dp));