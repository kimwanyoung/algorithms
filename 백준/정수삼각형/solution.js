const input = [
    "5",
    "7",
    "3 8",
    "8 1 0",
    "2 7 4 4",
    "4 5 2 6 5",
]

const n = Number(input[0]);

const arr = [];
for(let i = 1; i <= n; i++) {
    arr.push(input[i].split(" ").map(Number));
}


for(let i = 1; i < n; i++) {
    for(let j = 0; j <= i; j++) {
        let upLeft = 0;
        if(j !== 0) upLeft = arr[i - 1][j - 1];
        let upRight = 0;
        if(j !== i) upRight = arr[i - 1][j];

        arr[i][j] = arr[i][j] + Math.max(upLeft, upRight);
    }
}

console.log(Math.max(...arr[n - 1]));