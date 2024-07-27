const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const N = +input[0];
const M = +input[1];
const costs = input.slice(2).map(v => v.split(' ').map(Number));
const COST = 2;
costs.sort((a, b) => a[COST] - b[COST]);
const parent = Array.from(Array(N + 1), (_, i) => i);
let answer = 0;

for (let i = 0; i < costs.length; i++) {
    const [from, to, cost] = costs[i];
    if (!connected(from, to)) {
        union(from, to);
        answer += cost;
    }
}
console.log(answer);

function union(n1, n2) {
    const rootA = find(n1);
    const rootB = find(n2);
    if (rootA < rootB) parent[rootB] = rootA;
    else parent[rootA] = rootB;
}

function find(node) {
    if (parent[node] === node) return node;
    parent[node] = find(parent[node]);
    return parent[node];
}

function connected(n1, n2) {
    if (find(n1) !== find(n2)) return false
    else return true
}

