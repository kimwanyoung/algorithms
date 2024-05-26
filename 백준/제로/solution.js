/**
 * [solution]
 * - 빈 배열을 하나 선언한다.
 * - 0가 나오면 pop()을 통해 최근 값을 삭제한다.
 * - 마지막까지 실행한 후, 배열 내 원소 총 합을 반환한다.
 */

// const input = require("fs").readFileSync(0, "utf-8").split("\n").map(Number);
const input = [
    4,
    3,
    0,
    4,
    0,
];

const arr = [];
const K = input[0];

for(let i = 1; i <= K; i++) {
    if(!input[i]) {
        arr.pop();
    } else {
        arr.push(input[i]);
    }
}

const sum = arr.reduce((a, b) => a + b, 0);
console.log(sum);