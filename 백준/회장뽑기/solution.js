const input = [
    "5",
    "1 2",
    "2 3",
    "3 4",
    "4 5",
    "2 4",
    "5 3",
    "-1 -1",
]

const n = Number(input[0]);
const dp = Array.from(Array(n), () => new Array(n).fill(Infinity));

for(let i = 0; i < n; i++) {
    dp[i][i] = 0;
}

let i = 1;
while(true) {
    const [a, b] = input[i].split(" ").map(Number);
    if(a === -1 && b === -1) break;

    dp[a - 1][b - 1] = 1;
    dp[b - 1][a - 1] = 1;
    i++;
}

for(let k = 0; k < n; k++) {
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < n; j++) {
            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
    }
}

let min = Infinity;
let count = 0;
const candidates = [];
for(let i = 0; i < n; i++) {
    min = Math.min(min,Math.max(...dp[i]));
}

for(let i = 0; i < n; i++) {
    const currentMax = Math.max(...dp[i]);
    if(currentMax === min) {
        count++;
        candidates.push(i + 1);
    }
}

console.log(min, count);
console.log(candidates.join(" "));