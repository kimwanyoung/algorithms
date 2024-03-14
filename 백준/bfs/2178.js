const input = ['4 6', '101111', '101010', '101011', '111011'];

const [N, M] = input[0].split(" ").map((v) => +v);
const adjM = [];
for (let i = 1; i <= N; i++) {
    adjM.push(input[i].split("").map((v) => +v));
} // 미로 행렬
const check = Array.from({ length: N }, () => Array(M).fill(0)); // 방문 여부를 위한 체크

console.log(adjM);
console.log(check);

const bfs = (row, col) => {
    const dx = [-1, 0, 1, 0];
    const dy = [0, 1, 0, -1];
    const queue = [];
    queue.push([row, col]);
    check[row][col] = 1;
    while(queue.length) {
        const [x, y] = queue.shift();
        for (let i = 0; i < 4; i++) {
            const [nx, ny] = [x + dx[i], y + dy[i]];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if(adjM[nx][ny] && !check[nx][ny]) {
                check[nx][ny] = check[x][y] + 1;
                queue.push([nx, ny]);
            }
        }
    }

    return check[N - 1][M - 1];
}

console.log(bfs(0, 0));

