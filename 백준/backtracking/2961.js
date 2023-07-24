const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

function dfs(depth, start) {
  if (depth >= 1) {
    let totalX = 1;
    let totalY = 0;
    for (let i of result) {
      let [x, y] = graph[i];
      totalX *= x;
      totalY += y;
    }
    minValue = Math.min(minValue, Math.abs(totalX - totalY));
  }

  for (let i = start; i < material; i++) {
    if (visited[i]) continue;
    visited[i] = true;
    result.push(i);
    dfs(depth + 1, i + 1);
    visited[i] = false;
    result.pop();
  }
}

const material = Number(input[0]);
const graph = [];
for (let i = 1; i <= material; i++) {
  const materials = input[i].split(" ").map(Number);
  graph.push(materials);
}

const visited = new Array(material).fill(false);
let minValue = 1e9;
const result = [];

dfs(0, 0);
console.log(minValue);
