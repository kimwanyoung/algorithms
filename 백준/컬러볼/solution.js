const input = [
    "4",
    "1 10",
    "3 15",
    "1 3",
    "4 8",
]

const n = Number(input[0]);
const arr = [];
for(let i = 1; i <= n; i++) {
    const [c, s] = input[i].split(" ").map(Number);
    arr.push([c, s, i]);
}

arr.sort((a, b) => a[1] - b[1]);

let summary = 0;
let colorSummary = new Array(200001).fill(0);
let result = new Array(n).fill(0);

let start = 0;
while(start < n) {
    let end = start;
    while(end < n && arr[start][1] === arr[end][1]) end += 1;
    for(let i = start; i < end; i++) {
        result[arr[i][2]] = summary - colorSummary[arr[i][0]];
    }

    for(let i = start; i < end; i++) {
        colorSummary[arr[i][0]] += arr[i][1];
        summary += arr[i][1];
    }

    start = end;
}

console.log(result.slice(1).join("\n"));