const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map(Number);
const graph = [];
let visited = new Array(n + 1).fill(false);
let distance = new Array(n + 1).fill(-1);
for (let i = 1; i <= n; i++) graph[i] = [];
for (let i = 1; i < n; i++) {
  const [x, y, cost] = input[i].split(" ").map(Number);
  graph[x].push([y, cost]);
  graph[y].push([x, cost]);
}

const dfs = (x, dist) => {
  if (visited[x]) return;
  visited[x] = true;
  distance[x] = dist;
  for (const [y, cost] of graph[x]) dfs(y, dist + cost);
};

for (let i = 0; i < m; i++) {
  const [x, y] = input[n + i].split(" ").map(Number);
  visited = new Array(n + 1).fill(false);
  distance = new Array(n + 1).fill(-1);
  dfs(x, 0);
  console.log(distance[y]);
}
