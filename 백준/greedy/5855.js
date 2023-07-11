const input = require("fs").readFileSync("/dev/stdin").toString();

const changeList = [500, 100, 50, 10, 5, 1];

let changeCount = 0;
let change = 1000 - input;

let i = 0;
while (change !== 0) {
  const currentCount = parseInt(change / changeList[i]);
  changeCount += currentCount;
  change = change - currentCount * changeList[i];
  i++;
}

console.log(changeCount);
