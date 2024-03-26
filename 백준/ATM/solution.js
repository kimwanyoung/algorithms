const input = require('fs').readFileSync(0,'utf-8').split('\n')

const personCount = Number(input[0]);

const dueTime = input[1].split(' ').map(Number);
dueTime.sort((a, b) => a - b);

let time = 0;
let answer = 0;
for(let i = 0 ; i < dueTime.length; i++) {
    time += dueTime[i];
    answer += time;
}

console.log(answer);
