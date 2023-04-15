const input = require('fs').readFileSync('/dev/stdin').toString()

const b = input.split('-')

let sum = 0
for(let i = 0 ; i < b.length; i++){
  let cur = b[i].split('+').map(Number).reduce((a, b) => a + b)
  if(i === 0) sum += cur
  else sum -= cur
}

console.log(sum)