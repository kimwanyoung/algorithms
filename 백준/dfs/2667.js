const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const mapSize = Number(input[0]);

const graph = [];
for (let i = 0; i < mapSize; i++) {
  const line = input[i + 1].split("").map(Number);
  graph[i] = line;
}

let houseCount = 0;
let count = 0;
let house = [];

const dfs = (graph, x, y) => {
  if (x >= mapSize || y >= mapSize || x < 0 || y < 0) return false;
  if (graph[x][y] === 1) {
    count += 1;
    graph[x][y] = -1;

    dfs(graph, x - 1, y);
    dfs(graph, x, y - 1);
    dfs(graph, x + 1, y);
    dfs(graph, x, y + 1);

    return true;
  }

  return false;
};

for (let i = 0; i < mapSize; i++) {
  for (let j = 0; j < mapSize; j++) {
    if (dfs(graph, i, j)) {
      houseCount += 1;
      house.push(count);
      count = 0;
    }
  }
}

house.sort((a, b) => a - b);

console.log(houseCount);
for (const c of house) {
  console.log(c);
}
