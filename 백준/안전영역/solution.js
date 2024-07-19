const input = [
    "7",
    "9 9 9 9 9 9 9",
    "9 2 1 2 1 2 9",
    "9 1 8 7 8 1 9",
    "9 2 7 9 7 2 9",
    "9 1 8 7 8 1 9",
    "9 2 1 2 1 2 9",
    "9 9 9 9 9 9 9",
];

const N = Number(input.shift());
let area = input.map((item) => item.split(" ").map(Number));

let MAX = 0;
for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        MAX = Math.max(MAX, area[i][j]);
    }
}

let answer = 1;
for (let rain = 0; rain <= MAX; rain++) {
    answer = Math.max(answer, findSafeArea(rain));
}

console.log(answer);

function findSafeArea(rain) {
    const map = input.map((item) => item.split(" ").map(Number));
    let safeArea = 0;
    const visited = Array.from(Array(N), () => Array(N).fill(false));
    const dir = [
        [-1, 0],
        [0, 1],
        [1, 0],
        [0, -1],
    ];

    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            if (map[i][j] <= rain) {
                map[i][j] = 0;
            } else map[i][j] = 1;
        }
    }


    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            if (map[i][j] === 1 && !visited[i][j]) {
                safeArea++;
                dfs(i, j);
            }
        }
    }

    function dfs(i, j) {
        if (isValidRange(i, j) && !visited[i][j] && map[i][j] === 1) {
            visited[i][j] = true;
            for (let d of dir) {
                const [dx, dy] = [i + d[0], j + d[1]];
                dfs(dx, dy);
            }
        }
    }

    function isValidRange(i, j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    return safeArea;
}

