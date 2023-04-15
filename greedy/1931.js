const input = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const testCase = Number(input[0])
let room = []
for(let i = 1; i < input.length; i++){
    room.push(input[i].split(' ').map(Number))
}
room.sort((a, b) => {
  if(a[1] != b[1]) return a[1] - b[1]
  else return a[0] - b[0]
})

let cnt = 1
let roomTime = room[0]
for(let i = 1 ; i < room.length ; i++){
    if(roomTime[1] <= room[i][0]){
        cnt++
        roomTime = room[i]
    }
}

console.log(cnt)