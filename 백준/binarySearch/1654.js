const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [k, n] = input[0].split(" ").map(Number);

const lines = [];
for (let i = 1; i <= k; i++) lines.push(Number(input[i]));

let start = 1;
let end = Math.max(...lines);

let result = 0;
while (start <= end) {
  let sum = 0;
  const mid = parseInt((start + end) / 2);
  for (let x of lines) {
    const line = parseInt(x / mid);
    sum += line;
  }

  if (sum >= n) {
    start = mid + 1;
    result = mid;
  } else {
    end = mid - 1;
  }
}

console.log(result);
