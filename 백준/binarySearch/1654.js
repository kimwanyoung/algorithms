const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const line = Number(input[0].split(' ')[0])
const lineNumber = Number(input[0].split(' ')[1])
let lines = []
for(let i = 1; i <= line; i++){
    lines.push(Number(input[i]))
}

let start = 0
let end = lines.reduce((a, b) => Math.max(a, b))

let result = 0
while(start <= end){
  let mid = parseInt((start + end) / 2)
  let sum = 0
  for(let i of lines){
    sum += parseInt(i / mid)
  }
  if(sum < lineNumber){
    end = mid - 1
  }else {
     result = mid
    start = mid + 1
  }
}

console.log(result)