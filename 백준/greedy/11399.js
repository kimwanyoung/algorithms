const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const personNumber = Number(input[0])
const timeList = input[1].split(' ').map(Number).sort((a, b) => a - b)

let minutes = 0
let sum = 0
for(let i = 0 ; i < personNumber ; i ++){
    sum += timeList[i]
    minutes += sum
}

console.log(minutes)