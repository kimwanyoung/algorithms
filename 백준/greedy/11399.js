const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const personCount = Number(input[0]);
const personList = input[1].split(" ").map(Number);

personList.sort((a, b) => a - b);

let totalMinutes = 0;
let result = 0;
for (let i = 0; i < personCount; i++) {
  totalMinutes = totalMinutes + personList[i];
  result += totalMinutes;
}

console.log(result);
