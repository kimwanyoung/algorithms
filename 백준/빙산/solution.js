const input = [
    "5 7",
    "0 0 0 0 0 0 0",
    "0 2 4 5 3 0 0",
    "0 3 0 2 5 2 0",
    "0 7 6 2 4 0 0",
    "0 0 0 0 0 0 0",
];

const [n, m] = input[0].split(" ").map(Number);



let arr = [];
for(let i = 1; i <= n; i++) {
    arr.push(input[i].split(" ").map(Number));
}

const dy = [0, 0, 1, -1];
const dx = [-1, 1, 0, 0];

let answer = 0;
let visited = Array.from(Array(n), () => new Array(m).fill(0));

while(true) {
    let cnt = 0;
    visited = Array.from(Array(n), () => new Array(m).fill(0));

    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(!arr[i][j] || visited[i][j]) continue;

            cnt += 1;
            bfs(i, j);
        }
    }

    if(cnt === 0) {
        console.log(0);
        break;
    }
    if(cnt >= 2) {
        console.log(answer);
        break;
    }

    const copy = Array.from(Array(n), () => new Array(m).fill(0));

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (!arr[i][j]) continue;

            copy[i][j] = arr[i][j] - calculateZero(i, j);
            if (copy[i][j] < 0) copy[i][j] = 0;
        }
    }

    arr = copy;
    answer += 1;
}

function bfs(i, j) {
    const queue = [];
    queue.push([i, j]);
    visited[i][j] = true;

    while(queue.length !== 0) {
        const [x, y] = queue.shift();

        for(let k = 0; k < 4; k++) {
            const nx = x + dx[k];
            const ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (!arr[nx][ny] || visited[nx][ny]) continue;

            queue.push([nx, ny]);
            visited[nx][ny] = true;
        }
    }
}


function calculateZero(i, j) {
    let result = 0;

    for (let k = 0; k < 4; k++) {
        const nx = i + dx[k];
        const ny = j + dy[k];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
        if (arr[nx][ny] === 0) result += 1;
    }

    return result;
}