const input = require('fs').readFileSync('/dev/stdin').toString().split(' ')

let [number, goalNumber] = input.map(Number)

let cnt = 1
while(goalNumber >= number){
    if(goalNumber === number) break;
    let numberToStr = goalNumber.toString().split('')
    if(numberToStr[numberToStr.length - 1] === '1'){
        numberToStr.pop()
        goalNumber = Number(numberToStr.join(''))
    } else {
        goalNumber = goalNumber / 2
    }
    cnt += 1
}

if(goalNumber !== number) cnt = -1

console.log(cnt)