const input = [
    "8",
    "1.1",
    "0.7",
    "1.3",
    "0.9",
    "1.4",
    "0.8",
    "0.7",
    "1.4"
].map(Number);

const [n, ...numbers] = input;
console.log(numbers);
for(let i = 1; i < n; i++) {
    numbers[i] = Math.max(numbers[i], numbers[i] * numbers[i - 1]);
}
console.log(Math.max(...numbers).toFixed(3));