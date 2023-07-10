const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const numberCount = Number(input[0]);
const numberArray = [];
for (let i = 1; i <= numberCount; i++) numberArray[i - 1] = Number(input[i]);

numberArray.sort((a, b) => a - b);

let answer = "";
for (let i = 0; i < numberArray.length; i++) answer += numberArray[i] + "\n";
console.log(answer);
