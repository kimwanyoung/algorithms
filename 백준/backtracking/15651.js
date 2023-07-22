const input = require("fs").readFileSync("/dev/stdin").toString();

const [n, m] = input.split(" ").map(Number);

const arr = [];
for (let i = 1; i <= n; i++) arr.push(i);
const selected = [];

let answer = "";
function dfs(arr, depth) {
  if (depth == m) {
    let result = [];
    for (const i of selected) result.push(arr[i]);
    for (const x of result) answer += x + " ";
    answer += "\n";
    return;
  }
  for (let i = 0; i < arr.length; i++) {
    selected.push(i);
    dfs(arr, depth + 1);
    selected.pop();
  }
}

dfs(arr, 0);
console.log(answer);
