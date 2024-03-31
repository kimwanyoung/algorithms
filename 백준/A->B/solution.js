// const input = require('fs').readFileSync(0, 'utf-8').split(' ').map(Number);

const input = [2, 162];
let [number, goal] = input;

let flag = false;
let cnt = 1;
while(number <= goal) {
    if(number === goal) {
        flag = true;
        break;
    }
    if(goal % 2 === 0) {
        goal = parseInt(goal / 2);
    } else if(goal % 10 === 1) {
        goal = parseInt(goal / 10);
    } else {
        break;
    }
    cnt++;
}

if(flag) console.log(cnt);
else console.log(-1);
