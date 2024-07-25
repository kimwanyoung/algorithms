let input = [
    "12",
    "1 2 3",
    "1 3 2",
    "2 4 5",
    "3 5 11",
    "3 6 9",
    "4 7 1",
    "4 8 7",
    "5 9 15",
    "5 10 4",
    "6 11 6",
    "6 12 10",
]

const N = Number(input.shift());
const tree = Array.from(Array(N + 1), () => []);
input.forEach((info) => {
    const [a, b, dist] = info.split(" ").map(Number);
    tree[a].push([b, dist]);
    tree[b].push([a, dist]);
})
tree.sort((a, b) => a[0] - b[0]);

function bfs(s) {
    const check = new Array(N + 1).fill(0);
    const queue = [];
    queue.push([s, 0]);
    let max = { node: 0, dist: 0 };
    while (queue.length) {
        const [node, dist] = queue.shift();
        if (check[node]) continue;
        check[node] = 1;
        if (max.dist < dist) max = { node, dist };
        for (let [nextNode, nextDist] of tree[node]) {
            queue.push([nextNode, dist + nextDist]);
        }
    }
    return max;
}

console.log(bfs(bfs(1).node).dist);