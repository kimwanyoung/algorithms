// const input = require('fs').readFileSync(0, 'utf-8').split('\n');

const input = [
    '4',
    '100',
    '200',
    '12345',
    '1003',
]

const N = Number(input[0]);

const fib = (max) => {
    const fib = [0, 1];
    while(fib[fib.length -1] <= max) {
        fib.push(fib[fib.length - 1] + fib[fib.length - 2]);
    }
    return fib;
}

const fibArr = fib(1e9);

for(let i = 1; i <= N; i++) {
    let n = Number(input[i]);
    let result = [];
    let index = fibArr.length - 1;
    while(n > 0) {
        if( n >= fibArr[index] ) {
            n -= fibArr[index];
            result.push(fibArr[index]);
        }
        index--;
    }
    let answer = '';
    for(let j = result.length - 1; j >= 0; j--) answer += result[j] + ' ';
    console.log(answer);
}
