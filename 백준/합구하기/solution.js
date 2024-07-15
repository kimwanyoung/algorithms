const input = [
    "5",
    "10 20 30 40 50",
    "5",
    "1 3",
    "2 4",
    "3 5",
    "1 5",
    "4 4",
]

const n = Number(input[0]);
const numbers = input[1].split(" ").map(Number);
const query = Number(input[2]);

let sum = 0;
const prefixSum = [0];
for(const number of numbers) {
    sum += number;
    prefixSum.push(sum);
}

for(let i = 3; i < query + 3; i++) {
    const [start, end] = input[i].split(" ").map(Number);
    console.log(prefixSum[end] - prefixSum[start - 1]);
}