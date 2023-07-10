const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, k] = input[0].split(" ").map(Number);
const numberArr = input[1]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);
console.log(numberArr[k - 1]);
