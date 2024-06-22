const input = [
    "2 20 50",
    "50 30",
    "30 40",
]

const [N, L, R] = input[0].split(" ").map(Number);
const graph = [];
for(let i = 1 ; i <= N; i++) {
    const row = input[i].split(" ").map(Number);
    graph.push(row);
}

const dy = [0, -1, 0, 1];
const dx = [-1, 0, 1, 0];
let totalCount = 0;

while(true) {
    let union = Array.from(Array(N), () => Array(N).fill(-1));
    let index = 0;

    for(let i = 0; i < N; i++) {
        for(let j = 0; j < N; j++) {
            if(union[i][j] === -1) {
                bfs(i, j, index, union);
                index++;
            }
        }
    }

    if(index === N * N) break;
    totalCount++;
}
console.log(totalCount);

function bfs(x, y, index, union) {
    let united = [[x, y]];
    let queue = [];
    queue.push([x, y]);
    union[x][y] = index;

    let summary = graph[x][y];
    let cnt = 1;

    while(queue.length !== 0) {
        const [x, y] = queue.shift();

        for(let i = 0 ; i < 4; i++) {
            const nx = x + dx[i];
            const ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < N && union[nx][ny] === -1) {
                const diff = Math.abs(graph[nx][ny] - graph[x][y]);
                if(L <= diff && diff <= R) {
                    queue.push([nx, ny]);
                    union[nx][ny] = index;
                    summary += graph[nx][ny];
                    cnt++;
                    united.push([nx, ny]);
                }
            }
        }
    }

    for(const unit of united) {
        const [i, j] = unit;
        graph[i][j] = Math.floor(summary / cnt);
    }
}