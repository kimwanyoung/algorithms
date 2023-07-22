const input = require("fs").readFileSync("/dev/stdin").toString();

const n = Number(input);
const arr = [];
for (let i = 1; i <= n; i++) arr.push(i);
const visited = new Array(n).fill(false);
const selected = [];

let answer = "";
function dfs(arr, depth) {
  if (depth === n) {
    const result = [];
    for (const i of selected) result.push(arr[i]);
    for (const x of result) answer += x + " ";
    answer += "\n";
  }
  for (let i = 0; i < arr.length; i++) {
    if (visited[i]) continue;
    selected.push(i);
    visited[i] = true;
    dfs(arr, depth + 1);
    visited[i] = false;
    selected.pop();
  }
}

dfs(arr, 0);
console.log(answer);
