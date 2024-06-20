const input = [
    "3 3",
    "1 0 2",
    "0 0 0",
    "3 0 0",
    "2 3 2"
]

const [N, virusCategory] = input[0].split(" ").map(Number);
const [goalSec, x, y] = input[N + 1].split(" ").map(Number);

const virusMap = [];

for(let i = 1; i <= N; i++) {
    virusMap.push(input[i].split(" ").map(Number));
}

const queue = [];
for(let i = 0; i < N; i++) {
    for(let j = 0; j < N; j++) {
        const virus = virusMap[i][j];
        if(virus !== 0) queue.push([virus, i, j, 0]);
    }
}

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

queue.sort((a, b) => a[0] - b[0]);
while(queue.length !== 0) {
    const [curVirus, curY, curX, second] = queue.shift();
    if(second === goalSec) break;


    for(let i = 0; i < 4; i++) {
        const ddy = curY + dy[i];
        const ddx = curX + dx[i];
        if(ddy < 0 || ddy > N - 1 || ddx < 0 || ddx > N - 1) continue;

        if(virusMap[ddy][ddx] === 0) {
            virusMap[ddy][ddx] = curVirus;
            queue.push([curVirus, ddy, ddx, second + 1]);
        }
    }
}

console.log(virusMap[x - 1][y - 1]);
