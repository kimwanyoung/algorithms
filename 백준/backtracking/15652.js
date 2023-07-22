const input = require("fs").readFileSync("/dev/stdin").toString();

const [n, m] = input.split(" ").map(Number);

const arr = [];
for (let i = 1; i <= n; i++) arr.push(i);
const selected = [];

let answer = "";
function dfs(arr, depth, start) {
  if (depth == m) {
    let result = [];
    for (const i of selected) result.push(arr[i]);
    for (const x of result) answer += x + " ";
    answer += "\n";
    return;
  }
  for (let i = start; i < arr.length; i++) {
    selected.push(i);
    dfs(arr, depth + 1, i);
    selected.pop();
  }
}

dfs(arr, 0, 0);
console.log(answer);
