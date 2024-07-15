const input = [
    "5 3",
    "1 2 3 1 2",
]

const [n, m] = input[0].split(" ").map(Number);
const numbers = input[1].split(" ").map(Number);

const sum = [0];
for(let i = 1; i <= n; i++) {
    sum[i] = sum[i - 1] + numbers[i - 1];
}

const processed = [];
let counter = {};
for(let i = 0 ; i <= n; i++) {
    processed[i] = sum[i] % m;
    if(processed[i] in counter) counter[processed[i]] += 1;
    else counter[processed[i]] = 1;
}

let result = 0;
for(let i = 0; i < m; i++) {
    if(i in counter) result += parseInt(counter[i] * (counter[i] - 1) / 2);
}

console.log(result);