// const input = require('fs').readFileSync(0, 'utf-8').split('\n');
const input = ['5',
'0 4',
'1 2',
'1 -1',
'2 2',
'3 3'];
const count = Number(input[0]);
const graph = [];
for(let i = 1 ; i <= count; i++) {
    graph.push(input[i].split(' ').map(Number));
}

graph.sort((a, b) => {
    if(a[1] === b[1]) {
        return a[0] - b[0];
    }
    return a[1] - b[1];
});

let answer = ''
graph.forEach((numbers) => {
    answer += numbers.join(' ') + '\n';
})

console.log(answer);