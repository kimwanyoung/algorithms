const wordSorting = (a, b) => {
    if(a.length === b.length){
        if(a > b)return 1
        else if(a < b) return -1
        else return 0
    } else {
        return a.length - b.length
    }
}

const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const cnt = Number(input.shift())
let arr = []
for(let i = 0 ; i < cnt; i++){
    arr.push(input[i])
}
arr = [...new Set(arr)]
arr.sort(wordSorting)

for(let i of arr){
    console.log(i)
}