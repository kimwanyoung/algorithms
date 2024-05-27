/**
 * [solution]
 * - 최대값 max를 선언하고 배열에서 최대값을 찾아 초기화한다.
 * - 반복문을 돌며 최대값--를하고 첫번쨰 후보에 더해준다.
 * - 다시 max 업데이트해준다.
 * - 위 과정 첫번째 후보가 max보다 커질때까지 반복.
 */

const input = require("fs").readFileSync(0, "utf-8").split("\n");

const num = (input[0]);
const one = input[1];
const arr = input.slice(2);

const solution = (num, one, arr) => {
    if (num === 1) return 0;

    let max = Math.max(...arr)
    let count = 0

    while (one <= max) {
        arr[arr.indexOf(max)] -= 1
        one += 1;
        count++;
        max = Math.max(...arr);
    }

    return count
}

console.log(solution(num, one, arr));