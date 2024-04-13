// const input = require('fs').readFileSync(0, 'utf-8').split(' ');

const input = [6, 3];

let n = Number(input[0]);
const k = Number(input[1]);

let summary = 0;
for(let i = 0; i < k + 1; i++) {
    summary += i;
}

if(summary > n) {
    console.log(-1);
} else {
    n -= summary;
    if(n % k === 0) console.log(k - 1);
    else console.log(k);
}