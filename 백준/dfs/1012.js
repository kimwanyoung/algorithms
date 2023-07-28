const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

let testCase = Number(input[0]);

let currentTestCase = 1;
while (testCase--) {
  const [m, n, k] = input[currentTestCase].split(" ").map(Number);
  const graph = [];
  let count = 0;

  const dfs = (graph, x, y) => {
    if (x >= n || y >= m || x < 0 || y < 0) return false;
    if (graph[x][y] === 1) {
      graph[x][y] = -1;

      dfs(graph, x - 1, y);
      dfs(graph, x, y - 1);
      dfs(graph, x + 1, y);
      dfs(graph, x, y + 1);
      return true;
    }

    return false;
  };

  for (let j = 0; j < n; j++) {
    graph[j] = new Array(m);
  }

  for (let j = 1; j <= k; j++) {
    const [y, x] = input[currentTestCase + j].split(" ").map(Number);
    graph[x][y] = 1;
  }

  for (let j = 0; j < n; j++) {
    for (let x = 0; x < m; x++) {
      if (dfs(graph, j, x)) count++;
    }
  }
  console.log(count);
  currentTestCase += k + 1;
}
