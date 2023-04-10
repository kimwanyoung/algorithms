const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')
const inputs = input[1].split(' ').map(Number)

let numbers = [...new Set(inputs)]
let number = [...numbers]
let b = number.sort((a, b) => a - b)

let map = new Map()

for(let i = 0 ; i < b.length; i++){
  map.set(b[i], i)
}

let answer = ''
for(let i of inputs){
    answer += map.get(i) + ' '
}

console.log(answer)