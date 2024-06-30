/**
 * [solution]
 * - dp로 해결 가능
 * - n : 최대 좌석
 * - numbers: vip 좌석들
 */

const input = [
    9,
    2,
    4,
    7,
]

let n = input[0];
let m = input[1];

const d = new Array(50).fill(0);

d[0] = 1;
d[1] = 1;
d[2] = 2;

function dp(x) {
    if(d[x] !== 0) return d[x];
    d[x] = dp(x - 1) + dp(x - 2);
    return d[x];
}

const arr = [];
let start = 0;
for(let i = 2; i < m + 2; i++) {
    const end = input[i];
    arr.push(end - 1 - start);
    start = end;
}
arr.push(n - start);

let res = 1;
for(let x of arr) res *= dp(x);
console.log(res);
