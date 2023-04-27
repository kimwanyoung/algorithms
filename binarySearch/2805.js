let input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

let trees = input[1].split(' ').map(Number)
let max = Number(input[0].split(' ')[1])

let start = 0
let end = trees.reduce((a, b) => Math.max(a, b))

let result = 0
while(start <= end){
  let mid = parseInt((start + end) / 2)
  let total = 0
  for(let i of trees){
    if(i - mid < 0){
      total += 0
    } else {
      total += (i - mid)
    }
  }
  if(total < max){
    end = mid - 1
  } else if(total === max) {
    result = mid
    break
  } else {
    result = mid
    start = mid + 1
  }

}

console.log(result)