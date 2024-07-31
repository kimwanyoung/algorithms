const input = [
    "6 5",
    "1 1 0 1 1",
    "0 1 1 0 0",
    "0 0 0 0 0",
    "1 0 1 1 1",
    "0 0 1 1 1",
    "0 0 1 1 1",
]

const [n, m] = input.shift().split(" ").map(Number);
const graph = input.map((line) => line.split(" ").map(Number));
const visited = Array.from(Array(n), () => new Array(m).fill(false));

const dy = [0, 0, -1, 1];
const dx = [1, -1, 0, 0];

let count = 0;
let area = 0;
let maxArea = 0;
for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        if (graph[i][j] === 1 && visited[i][j] === false) {
            visited[i][j] = true;
            area = bfs(i, j);
            maxArea = Math.max(maxArea, area);
            count += 1;
        }
    }
}

console.log(count);
console.log(maxArea);

function bfs(r, c) {
    let area = 1;
    const queue = [];
    queue.push([r, c]);
    visited[r][c] = true;

    while(queue.length !== 0) {
        const [y, x] = queue.shift();

        for(let i = 0; i < 4; i++) {
            const next_y = y + dy[i];
            const next_x = x + dx[i];

            if(validateRange(next_y, next_x) && !visited[next_y][next_x] && graph[next_y][next_x] === 1) {
                area++;
                visited[next_y][next_x] = true;
                queue.push([next_y, next_x]);
            }
        }
    }

    return area;
}

function validateRange(y, x) {
    return x >= 0 && x < m && y >= 0 && y < n;
}