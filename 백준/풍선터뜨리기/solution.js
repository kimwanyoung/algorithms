// const input = require('fs').readFileSync(0, 'utf-8').split('\n');

const input = [
    '5',
    '4 5 2 1 4',
]

let data = input[1].split(' ').map(Number);
let result = 0;
let arrow = new Array(1000001).fill(0);
for(let x of data) {
    if(arrow[x] > 0) {
        arrow[x] -= 1;
    } else {
        result += 1;
    }
    arrow[x - 1] += 1;
}

console.log(result);