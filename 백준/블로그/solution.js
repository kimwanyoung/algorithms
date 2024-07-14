/**
 * [solution]
 * - 투 포인터를 이용해서 최대 방문자 수를 구한다.
 * - 그 후에 다시 한번 투포인터를 이용해서 최대 방문일자가 되는 구간의 개수를 구한다.
 */

const input = [
    "5 2",
    "1 4 2 5 1",
]

const [n, x] = input[0].split(" ").map(Number);
const visitors = input[1].split(" ").map(Number);

let max = 0;
let intervalSum = 0;
let end = 0;
let count = 0;

function twoPointer(targetNum) {
    for(let start = 0; start < n; start++) {
        while(end < start + x && end < n) {
            intervalSum += visitors[end++];
        }
        max = Math.max(max, intervalSum);
        if(intervalSum === targetNum) count++;
        intervalSum -= visitors[start];
    }
}

twoPointer(-1);
intervalSum = 0;
end = 0;
twoPointer(max);

if(max === 0) console.log("SAD");
else {
    console.log(max);
    console.log(count);
}


