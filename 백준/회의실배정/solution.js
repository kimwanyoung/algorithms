/*
    const input = [
        '11',
        '1 4',
        '3 5',
        '0 6',
        '5 7',
        '3 8',
        '5 9',
        '6 10',
        '8 11',
        '8 12',
        '2 13',
        '12 14',
    ]
*/

/**
 * 1. 종료 시간이 빠른대로 정렬을 한다.
 * 2. 종료 시간이 같다면 시작이간이 빠른 순으로 정렬한다.
 * 3. 첫번째 회의부터 겹치지 않게 최대한 많은 시간은 선택한다.
 */

const input = require('fs').readFileSync(0,'utf-8').split('\n');

const N = Number(input[0]);
const room = []
for(let i = 0; i < N; i++) {
    room.push(input[i + 1].split(' ').map(Number));
}

room.sort((a, b) => {
    if(a[1] === b[1]) {
        return a[0] - b[0];
    }
    return a[1] - b[1];
})

let count = 0;
let currentEndTime = 0;
for(let i = 0; i < room.length; i++) {
    if(room[i][0] >= currentEndTime) {
        count++;
        currentEndTime = room[i][1];
    }
}
console.log(count);