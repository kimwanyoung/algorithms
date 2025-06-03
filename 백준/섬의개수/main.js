// const fs = require("fs");
// const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const input = [
  "1 1",
  "0",
  "2 2",
  "0 1",
  "1 0",
  "3 2",
  "1 1 1",
  "1 1 1",
  "5 4",
  "1 0 1 0 0",
  "1 0 0 0 0",
  "1 0 1 0 1",
  "1 0 0 1 0",
  "5 4",
  "1 1 1 0 1",
  "1 0 1 0 1",
  "1 0 1 0 1",
  "1 0 1 1 1",
  "5 5",
  "1 0 1 0 1",
  "0 0 0 0 0",
  "1 0 1 0 1",
  "0 0 0 0 0",
  "1 0 1 0 1",
  "0 0",
];

let testcase = 0;
let lands = 0;
while (true) {
  const [w, h] = input[testcase].split(" ").map(Number);

  if (w === 0 && h === 0) break;

  const map = [];
  const visited = Array.from({ length: h }, () => Array(w).fill(false));
  for (let i = testcase + 1; i < testcase + 1 + h; i++) {
    const line = input[i].trim().split(" ").map(Number);
    map.push(line);
  }

  for (let i = 0; i < h; i++) {
    for (let j = 0; j < w; j++) {
      if (map[i][j] === 1 && !visited[i][j]) {
        if (bfs(map, visited, i, j)) {
          lands++;
        }
      }
    }
  }

  console.log(lands);
  lands = 0;
  testcase += h + 1;
}

function bfs(map, visited, y, x) {
  const queue = [];
  const directions = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
    [-1, -1],
    [-1, 1],
    [1, -1],
    [1, 1],
  ];

  let count = 0;
  queue.push([y, x]);
  visited[y][x] = true;
  while (queue.length > 0) {
    const [cy, cx] = queue.shift();

    if (map[cy][cx] === 1) count++;

    for (const [dy, dx] of directions) {
      const ny = cy + dy;
      const nx = cx + dx;

      if (isInvalid(ny, map, nx, visited)) continue;

      queue.push([ny, nx]);
      visited[ny][nx] = true;
    }
  }

  return count > 0;
}

function isInvalid(ny, map, nx, visited) {
  return (
    ny < 0 ||
    ny >= map.length ||
    nx < 0 ||
    nx >= map[0].length ||
    visited[ny][nx] ||
    map[ny][nx] === 0
  );
}
