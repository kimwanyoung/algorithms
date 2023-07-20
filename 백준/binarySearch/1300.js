const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = Number(input[0]);
const k = Number(input[1]);

let start = 1;
let end = n * n;

let result = 0;
while (start <= end) {
  let mid = parseInt((start + end) / 2);
  let total = 0;
  for (let i = 1; i <= n; i++) {
    total += Math.min(parseInt(mid / i), n);
  }
  if (total >= k) {
    result = mid;
    end = mid - 1;
  } else start = mid + 1;
}

console.log(result);
