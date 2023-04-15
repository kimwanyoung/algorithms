const input = require('fs').readFileSync('/dev/stdin').toString()

let kg = Number(input)
let cnt = 0
let flag = false

while(kg >= 0){
    if(kg === 0 || kg % 5 === 0){
        cnt += Math.floor(kg / 5)
        console.log(cnt)
        flag = true
        break;
    }
    kg -= 3
    cnt += 1
}

if(!flag){
    console.log(-1)
}