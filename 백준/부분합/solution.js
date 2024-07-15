const input = [
    "10 15",
    "5 1 3 5 10 7 4 9 2 8",
]

const [n, s] = input[0].split(" ").map(Number);
const numbers = input[1].split(" ").map(Number);

let result = 1e9;
let start = 0;
let end = 0;
let summary = numbers[0];

while(true) {
    while(end < n - 1 && summary < s) {
        end++;
        summary += numbers[end];
    }
    if(summary >= s) {
        result = Math.min(result, end - start + 1);
    }
    summary -= numbers[start];
    start++;
    if(start >= n) break;
}

if(result === 1e9) console.log(0);
else console.log(result);