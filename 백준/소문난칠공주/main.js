// const input = require("fs").readFileSync("/dev/stdin", "utf8").split("\n");
const input = ["YYYYY", "SYSYS", "YYYYY", "YSYYS", "YYYYY"];

const map = input.map((line) => line.split(""));
const totalVisited = Array(25).fill(false);
let result = 0;

function search(idx, yCnt, depth) {
  if (yCnt > 3) {
    return;
  }

  if (depth === 7) {
    if (bfs(Math.floor((idx - 1) / 5), (idx - 1) % 5)) {
      result++;
    }
    return;
  }

  for (let i = idx; i < 25; i++) {
    totalVisited[i] = true;
    if (map[Math.floor(i / 5)][i % 5] === "Y") {
      search(i + 1, yCnt + 1, depth + 1);
    } else {
      search(i + 1, yCnt, depth + 1);
    }
    totalVisited[i] = false;
  }
}

function bfs(y, x) {
  const visited = Array.from({ length: 5 }, () => Array(5).fill(false));
  const queue = [[y, x]];
  visited[y][x] = true;

  const directions = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
  ];

  let cnt = 1;
  while (queue.length > 0) {
    const [cy, cx] = queue.shift();

    for (const [dy, dx] of directions) {
      const ny = cy + dy;
      const nx = cx + dx;

      if (
        validateRange(ny, nx) ||
        visited[ny][nx] ||
        !totalVisited[ny * 5 + nx]
      ) {
        continue;
      }

      visited[ny][nx] = true;
      queue.push([ny, nx]);
      cnt++;
    }
  }

  return cnt === 7;
}

function validateRange(ny, nx) {
  return ny < 0 || ny >= 5 || nx < 0 || nx >= 5;
}

search(0, 0, 0);
console.log(result);
