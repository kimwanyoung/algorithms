const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

let n = Number(input[0])

let user = []
for(let i = 1; i <= n; i++){
    let age = Number(input[i].split(' ')[0])
    let name = input[i].split(' ')[1]
    user.push([age, name])
}

user.sort((a, b) => a[0] - b[0])

let answer = ''
for(let i of user){
    answer += i[0] + ' ' + i[1] + '\n'
}

console.log(answer)