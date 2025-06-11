// const input = require("fs")
//   .readFileSync("/dev/stdin", "utf8")
//   .split("\n");

const input = [
  "15 15",
  "2 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 0 0 0 0 1",
  "1 1 1 1 1 1 1 1 1 1 0 1 1 1 1",
  "1 1 1 1 1 1 1 1 1 1 0 1 0 0 0",
  "1 1 1 1 1 1 1 1 1 1 0 1 1 1 1",
];

const [N, M] = input[0].split(" ").map(Number);
const map = input.slice(1, N + 1).map((line) => line.split(" ").map(Number));
let [globalY, globalX] = [0, 0];

const totalDistances = Array.from({ length: N }, () => Array(M).fill(0));

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (map[i][j] === 2) {
      globalY = i;
      globalX = j;
    }

    if(map[i][j] === 0) {
        totalDistances[i][j] = -1;
    }
  }
}

bfs(globalY, globalX);

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (map[i][j] === 1 && totalDistances[i][j] === 0) {
      totalDistances[i][j] = -1;
    }

    if(map[i][j] === 0 && totalDistances[i][j] === -1) {
        totalDistances[i][j] = 0;
    }
  }
}

function bfs(y, x) {
  const visited = Array.from({ length: N }, () => Array(M).fill(false));
  const queue = [[y, x]];

  visited[y][x] = true;
  const directions = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
  ];

  while (queue.length > 0) {
    const [cy, cx] = queue.shift();

    for (const [dy, dx] of directions) {
      const ny = cy + dy;
      const nx = cx + dx;

      if (
        ny < 0 ||
        ny >= N ||
        nx < 0 ||
        nx >= M ||
        visited[ny][nx] ||
        map[ny][nx] === 0
      ) {
        continue;
      }

      queue.push([ny, nx]);
      visited[ny][nx] = true;
      totalDistances[ny][nx] = totalDistances[cy][cx] + 1;
    }
  }
}


let answer = "";
for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    answer += totalDistances[i][j] + " ";
  }

  answer += "\n";
}

console.log(answer.trim());