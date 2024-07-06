const input = [
    9,
    2,
    4,
    7,
]

const n = Number(input[0]);
const m = Number(input[1]);
const dp = new Array(41).fill(0);

dp[0] = 1;
dp[1] = 1;
dp[2] = 2;

function d(n) {
    if(dp[n] !== 0) return dp[n];
    dp[n] = d(n - 1) + d(n - 2); // 점화식 d[n] = d[n - 1] + d[n - 2];
    return dp[n];
}

const arr = [];
let start = 0;
for(let i = 2; i < m + 2; i++) {
    const end = Number(input[i]);
    arr.push(end - 1 - start); // arr에 각 vip좌석 사이에 존재하는 좌석 개수 삽입
    start = end; // start를 현재 vip좌석으로 업데이트
}

arr.push(n - start); // 마지막에 할당된 end를 총 좌석에서 빼주면서 마지막에 남은 좌석 개수 확인

let result = 1;
for(const num of arr) {
    result *= d(num);
}

console.log(result);