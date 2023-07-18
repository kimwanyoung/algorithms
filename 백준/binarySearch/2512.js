const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const arr = input[1].split(" ").map(Number);
const totalCost = Number(input[2]);

let start = 1;
let end = Math.max(...arr);

let result = 0;
while (start <= end) {
  let mid = parseInt((start + end) / 2);
  let total = 0;
  for (let x of arr) {
    total += Math.min(mid, x);
  }
  if (total <= totalCost) {
    result = mid;
    start = mid + 1;
  } else {
    end = mid - 1;
  }
}

console.log(result);
