/**
 * [solution]
 * - 투 포인터로 해결가능
 * - start, end모두 0번 인덱스 만약, 0번이 홀수라면 짝수가 될 때까지 start, end ++;
 * - 짝수라면 end++, length++, end의 위치가 홀수리면 k--; end++;
 * - k가 0이 될때까지 반복, 만약 k가 0이라면 start = end; k = originK;
 * - 배열 끝까지 반복
 */

const input = [
    "8 2",
    "1 2 3 4 5 6 7 8",
]

const [n, k] = input[0].split(" ").map(Number);
const numbers = input[1].split(" ").map(Number);

let result = 0;
let eraseCount = 0;
for(let start = 0, end = 0; start < n; start++) {
    while(end < n) {
        if(numbers[end] % 2 === 0) end++;
        else {
            if(eraseCount === k) break;
            eraseCount++;
            end++;
        }
    }
    result = Math.max(result, end - start - eraseCount);
    if(numbers[start] % 2 !== 0) eraseCount--;
}

console.log(result);