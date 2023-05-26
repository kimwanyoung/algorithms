const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const numberList = input[1].split(' ').map(Number)
const findNumberList = input[3].split(' ').map(Number)

const lowerBound = (arr, target, start, end) => {
  while(start < end) {
    let mid = parseInt((start + end) / 2)
    if(arr[mid] >= target) end = mid
    else start = mid  + 1
  }
  return end
}

const upperBound = (arr, target, start, end) => {
  while(start < end) {
    let mid = parseInt((start + end) / 2)
    if(arr[mid] > target) end = mid
    else start = mid  + 1
  }
  return end
}


numberList.sort((a, b) => a - b)

let result = ''
for(let i = 0; i < findNumberList.length; i++){
  let startIndex = lowerBound(numberList, findNumberList[i], 0, numberList.length)
  let endIndex = upperBound(numberList, findNumberList[i], 0, numberList.length)
  result += endIndex - startIndex + ' '
}

console.log(result)