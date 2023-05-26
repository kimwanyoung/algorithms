const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const [cnt, money] = input.shift().split(' ').map(Number)
const unit = input.map(Number).sort((a, b) => b - a)

let count = 0
function getExchange(money, unitArr, idx){
    if(money === 0) return;
    if(idx > unitArr.length) return;
    count += Math.floor(money / unitArr[idx])
    let other = money % unitArr[idx]
    return getExchange(other, unitArr, idx + 1)
}

getExchange(money, unit, 0)
console.log(count)