// const input = require('fs').readFileSync('/dev/stdin').trim().toString();

const input = '5\n' +
    '5\n' +
    '2\n' +
    '3\n' +
    '4\n' +
    '1';

const inputNumbers = input.split('\n').map(Number).slice(1);
inputNumbers.sort((a, b) => a - b);

inputNumbers.forEach((number) => {
    console.log(number);
})