const input = require('fs').readFileSync('/dev/stdin').toString().split(' ')

let [n, m] = input.map(Number)
let arr = []
for(let i = 1; i<= n; i++) arr.push(i)
let visited = new Array(n).fill(false)
let selected = []

let answer = ''
const dfs = (arr, depth) => {
  if(depth === m){
    let result = []
    for(let i of selected) result.push(i)
    for(let x of result) answer += x + " "
    answer += "\n"
    return
  }
  for(let i = 1; i <= arr.length; i++){
    if(visited[i]) continue
    selected.push(i)
    visited[i] = true
    dfs(arr, depth + 1)
    selected.pop()
    visited[i] = false
  }
}

dfs(arr, 0)
console.log(answer)