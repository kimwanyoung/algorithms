const input = require('fs').readFileSync('/dev/stdin').toString().split(' ')

let [number, goalNumber] = input.map(Number)

let cnt = 1
while(goalNumber >= number){
    if(goalNumber === number) break;
    if(goalNumber % 10 === 1){
        goalNumber = parseInt(goalNumber / 10)
    } else {
        goalNumber = goalNumber / 2
    }
    cnt += 1
}

if(goalNumber !== number) cnt = -1

console.log(cnt)