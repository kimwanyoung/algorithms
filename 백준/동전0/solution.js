// const input = require('fs').readFileSync(0, 'utf-8').split('\n');

const input = [
    "10 4200",
    "1",
    "5",
    "10",
    "50",
    '100',
    '500',
    '1000',
    '5000',
    '10000',
    '50000',
]
let [count, money] = input[0].split(' ').map(Number);
const coin = [];

for(let i = count; i >= 1; i--) {
    coin.push(Number(input[i]));
}

let i = 0;
let answer = 0;
while(money !== 0) {
    answer += Math.floor(money / coin[i]);
    money = money % coin[i];
    i++;
}

console.log(answer);