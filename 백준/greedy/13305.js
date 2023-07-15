const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const stationCount = Number(input[0]);
const distance = input[1].split(" ").map(Number);
const oilCost = input[2].split(" ").map(Number);

let totalCost = BigInt(0);
let minCost = oilCost[0];
for (let i = 0; i < stationCount - 1; i++) {
  if (minCost > oilCost[i]) minCost = oilCost[i];
  totalCost += BigInt(minCost) * BigInt(distance[i]);
}

console.log(String(totalCost));
