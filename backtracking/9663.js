let input = require('fs').readFileSync('/dev/stdin').toString()

let n = Number(input)

let queen = []
const possible = (x, y) => {
  for(let [a, b] of queen){
    if(a === x || b === y) return false
    if(Math.abs(a - x) === Math.abs(b - y)) return false
  }
  return true
}


let count = 0
const dfs = (row) => {
  if(n === row) count += 1
  for(let i = 0; i < n; i++){
    if(!possible(row, i))continue
    queen.push([row, i])
    dfs(row + 1)
    queen.pop()
  }
}

dfs(0)
console.log(count)