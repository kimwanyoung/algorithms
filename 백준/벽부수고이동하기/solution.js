class Queue {
    constructor() {
        this.data = [];
        this.head = 0;
        this.tail = 0;
    }

    push(item) {
        this.data[this.tail++] = item;
    }

    pop() {
        this.head++;
    }

    front() {
        return this.data[this.head];
    }

    rear() {
        return this.data[this.tail - 1];
    }

    isEmpty() {
        return this.head === this.tail;
    }

    size() {
        return Math.abs(this.head - this.tail);
    }
}

const input = [
    "6 4",
    "0100",
    "1110",
    "1000",
    "0000",
    "0111",
    "0000",
]

const [n, m] = input.shift().split(" ").map(Number);
const graph = input.map(e => e.split("").map(Number));

const dy = [1, -1, 0, 0];
const dx = [0, 0, -1, 1];
const distance = Array.from(Array(n), () => new Array(m).fill(0));

console.log(bfs());

function bfs() {
    const queue = new Queue();
    const visited = Array.from(Array(n), () => Array.from(Array(m), () => new Array(2).fill(false)));
    queue.push([0, 0, 0]);
    visited[0][0][0] = true;
    distance[0][0] = 1;

    while (!queue.isEmpty()) {
        const [x, y, wall] = queue.front();
        queue.pop();

        if (x === n - 1 && y === m - 1) {
            return distance[x][y];
        }

        for (let i = 0; i < 4; i++) {
            const nx = x + dx[i];
            const ny = y + dy[i];

            if (!validateRange(nx, ny)) continue;

            if (graph[nx][ny] === 1 && wall === 0 && !visited[nx][ny][1]) {
                visited[nx][ny][1] = true;
                distance[nx][ny] = distance[x][y] + 1;
                queue.push([nx, ny, 1]);
            }

            if (graph[nx][ny] === 0 && !visited[nx][ny][wall]) {
                visited[nx][ny][wall] = true;
                distance[nx][ny] = distance[x][y] + 1;
                queue.push([nx, ny, wall]);
            }
        }
    }

    return -1;
}

function validateRange(x, y) {
    return x >= 0 && x < n && y >= 0 && y < m;
}