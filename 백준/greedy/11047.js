const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const coinList = [];
let [n, k] = input[0].split(" ").map(Number);
for (let i = n; i > 0; i--) {
  coinList[n - i] = Number(input[i]);
}

let coinCount = 0;
let i = 0;
while (k !== 0) {
  const currentCount = parseInt(k / coinList[i]);
  coinCount += currentCount;
  k -= coinList[i] * currentCount;
  i++;
}

console.log(coinCount);
