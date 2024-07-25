const input = [
    "9",
    "8 6",
    "7",
    "1 2",
    "1 3",
    "2 7",
    "2 8",
    "2 9",
    "4 5",
    "4 6"
]

const total = Number(input[0]);
const [n, m] = input[1].split(" ").map(Number);
const lines = Number(input[2]);
const graph = [];
for(let i = 0; i <= total; i++) graph[i] = [];
for(let i = 3; i < lines + 3; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    graph[a].push(b);
    graph[b].push(a);
}

console.log(bfs(n));
function bfs(number) {
    const queue = [];
    const visited = new Array(total).fill(false);
    queue.push([number, 0]);
    visited[number] = true;

    while(queue.length !== 0) {
        const [current, relations] = queue.shift();
        if(current === m) return relations;

        for(const next of graph[current]) {
            if(!visited[next]) {
                queue.push([next, relations + 1]);
                visited[next] = true;
            }
        }
    }

    return -1;
}