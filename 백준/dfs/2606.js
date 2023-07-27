const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const node = Number(input[0]);
const edge = Number(input[1]);

const visited = Array(node + 1).fill(false);
const graph = [];
for (let i = 0; i <= node; i++) graph.push([]);
for (let i = 2; i <= edge + 1; i++) {
  const [x, y] = input[i].split(" ").map(Number);
  graph[x].push(y);
  graph[y].push(x);
}

let count = 0;
const dfs = (graph, visited, node) => {
  visited[node] = true;
  for (const y of graph[node]) {
    if (!visited[y]) {
      dfs(graph, visited, y);
      count += 1;
    }
  }
};

dfs(graph, visited, 1);
console.log(count);
