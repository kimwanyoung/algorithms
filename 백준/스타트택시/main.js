// const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin', 'utf8').trim().split('\n');
const input = [
  "6 3 15",
  "0 0 1 0 0 0",
  "0 0 1 0 0 0",
  "0 0 0 0 0 0",
  "0 0 0 0 0 0",
  "0 0 0 0 1 0",
  "0 0 0 1 0 0",
  "6 5",
  "2 2 5 6",
  "5 4 1 6",
  "4 2 3 5"
];

const [N, M, F] = input[0].split(' ').map(Number);
let fuel = F;
let [taxiY, taxiX] = input[N + 1].split(' ').map(x => Number(x) - 1);

const map = input.slice(1, N + 1).map(row => row.split(' ').map(Number));
const passengers = [];
for (let i = 0; i < M; i++) {
    let [sy, sx, ey, ex] = input[N + 2 + i].split(' ').map(x => Number(x) - 1);
    passengers.push({ sy, sx, ey, ex, picked: false });
}

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

function inRange(y, x) {
    return y >= 0 && y < N && x >= 0 && x < N;
}

// BFS로 가장 가까운 승객 찾기
function findPassenger(y, x) {
    const visited = Array.from({ length: N }, () => Array(N).fill(false));
    const queue = [[y, x, 0]];
    visited[y][x] = true;
    let found = [];
    let minDist = Infinity;

    while (queue.length > 0) {
        const [cy, cx, dist] = queue.shift();
        if (dist > minDist) break;

        for (let i = 0; i < passengers.length; i++) {
            const p = passengers[i];
            if (!p.picked && p.sy === cy && p.sx === cx) {
                found.push({ ...p, dist, idx: i });
                minDist = dist;
            }
        }

        for (let d = 0; d < 4; d++) {
            const ny = cy + dy[d], nx = cx + dx[d];
            if (inRange(ny, nx) && !visited[ny][nx] && map[ny][nx] === 0) {
                visited[ny][nx] = true;
                queue.push([ny, nx, dist + 1]);
            }
        }
    }

    if (found.length === 0) return null;
    found.sort((a, b) =>
        a.dist - b.dist ||
        a.sy - b.sy ||
        a.sx - b.sx
    );
    return found[0];
}

// BFS로 목적지까지 이동
function moveToDest(y, x, ey, ex) {
    const visited = Array.from({ length: N }, () => Array(N).fill(false));
    const queue = [[y, x, 0]];
    visited[y][x] = true;

    while (queue.length > 0) {
        const [cy, cx, dist] = queue.shift();
        if (cy === ey && cx === ex) return dist;

        for (let d = 0; d < 4; d++) {
            const ny = cy + dy[d], nx = cx + dx[d];
            if (inRange(ny, nx) && !visited[ny][nx] && map[ny][nx] === 0) {
                visited[ny][nx] = true;
                queue.push([ny, nx, dist + 1]);
            }
        }
    }
    return -1;
}

let success = true;
for (let cnt = 0; cnt < M; cnt++) {
    const passenger = findPassenger(taxiY, taxiX);
    if (!passenger || fuel < passenger.dist) {
        success = false;
        break;
    }
    fuel -= passenger.dist;
    passengers[passenger.idx].picked = true;

    const toDest = moveToDest(passenger.sy, passenger.sx, passenger.ey, passenger.ex);
    if (toDest === -1 || fuel < toDest) {
        success = false;
        break;
    }
    fuel -= toDest;
    fuel += toDest * 2;
    taxiY = passenger.ey;
    taxiX = passenger.ex;
}

console.log(success ? fuel : -1);