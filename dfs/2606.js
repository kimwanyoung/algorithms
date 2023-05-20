const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const n = Number(input[0]);
const m = Number(input[1]);
const graph = [];
for (let i = 1; i <= n; i++) graph[i] = [];
for (let i = 2; i <= m + 1; i++) {
  const [x, y] = input[i].split(" ").map(Number);
  graph[x].push(y);
  graph[y].push(x);
}

let cnt = 0;
const visited = new Array(n + 1).fill(false);

const dfs = (x) => {
  visited[x] = true;
  cnt++;
  for (const y of graph[x]) {
    if (!visited[y]) dfs(y);
  }
};

dfs(1);
console.log(cnt - 1);
