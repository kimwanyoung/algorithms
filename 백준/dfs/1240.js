const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [node, pair] = input[0].split(" ").map(Number);

const graph = [];
for (let i = 1; i <= node; i++) graph[i] = [];
for (let i = 1; i < node; i++) {
  const [x, y, distance] = input[i].split(" ").map(Number);
  graph[x].push([y, distance]);
  graph[y].push([x, distance]);
}

for (let i = 0; i < pair; i++) {
  const [x, y] = input[node + i].split(" ").map(Number);

  let visited = new Array(pair + 1).fill(false);
  let distance = new Array(pair + 1).fill(-1);

  const dfs = (x, dist) => {
    if (visited[x]) return;
    visited[x] = true;
    distance[x] = dist;
    for (const [y, cost] of graph[x]) dfs(y, dist + cost);
  };

  dfs(x, 0);
  console.log(distance[y]);
}
