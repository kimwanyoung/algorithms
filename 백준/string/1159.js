const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const player = Number(input[0]);
let firstNames = [];
let firstNamesDict = {};
let answer = [];

for (let i = 1; i <= player; i++) firstNames.push(input[i][0]);
firstNames = [...new Set(firstNames)];

for (let i = 0; i < firstNames.length; i++) {
  firstNamesDict[firstNames[i]] = 0;
}

for (let i = 1; i <= player; i++) {
  if (firstNames.includes(input[i][0])) {
    firstNamesDict[input[i][0]] += 1;
  }
}

for (let [name, cnt] of Object.entries(firstNamesDict)) {
  if (cnt >= 5) answer.push(name);
}

answer.sort();
console.log(answer.length === 0 ? "PREDAJA" : answer.join(""));
