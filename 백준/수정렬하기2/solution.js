const input = require('fs').readFileSync(0, 'utf-8').trim().toString();

const inputNumbers = input.split('\n').map(Number).slice(1);
inputNumbers.sort((a, b) => a - b);

let answer = '';
for(let i = 0 ; i < inputNumbers.length; i++) {
    answer += inputNumbers[i].toString() + '\n';
}
console.log(answer);