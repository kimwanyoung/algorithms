const input = require("fs").readFileSync("/dev/stdin").toString();
// '3 1 2'
const numbers = input.split(' ').map(Number);
let answer = '';
numbers.sort((a, b) => {
    return a - b;
});

console.log(numbers.join(' '));