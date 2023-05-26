const input = require('fs').readFileSync('/dev/stdin').toString().split(' ')

const [balls, teams] = input.map(Number)
let sum = teams * (teams + 1) / 2
if(sum > balls) console.log(-1)
else {
    let n = balls - sum
    if(n % teams === 0) console.log(teams - 1)
    else console.log(teams)
}