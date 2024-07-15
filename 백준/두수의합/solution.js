/**
 *
 * [solution]
 * - 숫자 배열을 정렬한다.
 * - start = 0, end = n - 1
 * - 여기서 end를 감소시키면 숫자를 감소시기는 것이고, start를 증가시면 숫자 증가시키는 것
 * - a1 + a2 = x라면 result++, end-=1
 * - start++;
 * - start >= end break
 */

const input = [
    "9",
    "5 12 7 10 9 1 2 3 11",
    "13"
]

const n = Number(input[0]);
const numbers = input[1].split(" ").map(Number);
const x = Number(input[2]);

numbers.sort((a, b) => a - b);

let result = 0;
let start = 0;
let end = n - 1;
while(true) {
    while(end > 0 && numbers[start] + numbers[end] > x) end -= 1;
    if(numbers[start] + numbers[end] === x) {
        result++;
        end -= 1;
    }
    start += 1;
    if(start >= end) break;
}

console.log(result);

