const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const n = Number(input[0])
const a = input[1].split(' ').map(Number)
const b = input[2].split(' ').map(Number)


const sorting = (method, arr) => {
  if(method === 'descending'){
    arr.sort((a, b) => b - a)
  }
  if(method === 'ascending'){
    arr.sort((a, b) => a - b)
  }
}

sorting('descending', a)
sorting('ascending', b)

let sum = 0
for(let i = 0 ; i < n; i++){
  sum += a[i] * b[i]
}

console.log(sum)