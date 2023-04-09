const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

let cnt = Number(input[0])

let arr = []
for(let i = 1; i <= cnt; i++){
    arr.push(Number(input[i]))
}

arr.sort((a, b) => a - b)

let answer = ''
for(let i = 0 ; i < arr.length; i++){
    answer += arr[i] + '\n'
}

console.log(answer)