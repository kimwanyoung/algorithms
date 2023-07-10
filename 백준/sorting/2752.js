const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const sortedArray = input.sort((a, b) => a - b);

console.log(sortedArray.join(" "));
