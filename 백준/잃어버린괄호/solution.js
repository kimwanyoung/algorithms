const input = reuqire('fs').readFileSync(0,'utf-8').trim();

const splitBasedOnMinus = input.split('-')

let sum = 0
for(let i = 0; i < splitBasedOnMinus.length; i++){
    let current = splitBasedOnMinus[i].split('+').map(Number).reduce((a, b) => a + b)
    if(i === 0) sum += current
    else sum -= current
}

console.log(sum)