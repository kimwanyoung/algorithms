const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const cardCount = Number(input[0]);
const havingCard = input[1].split(" ").map(Number);

const cardTable = {};
for (let i = 0; i < cardCount; i++) {
  const card = havingCard[i];
  if (cardTable[card] !== undefined) cardTable[card] += 1;
  else cardTable[card] = 1;
}

const findCount = Number(input[2]);
const findCards = input[3].split(" ").map(Number);

let answer = "";
for (let i = 0; i < findCount; i++) {
  const findCard = !cardTable[findCards[i]] ? 0 : cardTable[findCards[i]];
  answer += findCard + " ";
}

console.log(answer);
