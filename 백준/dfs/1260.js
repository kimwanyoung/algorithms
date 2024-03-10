const input = require("fs")
    .readFileSync("/dev/stdin")
    .toString()
    .trim()
    .split("\n");


const [N, M, V] = input[0].split(" ").map(Number);

//인접행렬 구하기
const graph = Array.from(Array(N + 1), () => new Array(N + 1).fill(0));

for (let i = 1; i <= M; i++) {
    let [row, column] = input[i].split(" ").map(Number);
    graph[row][column] = 1;
    graph[column][row] = 1;
}

const DFS_visited = new Array(N + 1).fill(false);
const DFS_answer = [];
const BFS_visited = new Array(N + 1).fill(false);
const BFS_answer = [];

function DFS(V) {
    DFS_visited[V] = true;
    DFS_answer.push(V);
    for (let i = 1; i < graph.length; i++) {
        if (graph[V][i] === 1 && DFS_visited[i] === false) {
            DFS(i);
        }
    }
}

function BFS(V) {
    const queue = [];
    BFS_visited[V] = true;
    BFS_answer.push(V);
    queue.push(V);

    while (queue.length !== 0) {
        let dequeue = queue.shift();
        for (let i = 1; i < graph.length; i++) {
            if (graph[dequeue][i] === 1 && BFS_visited[i] === false) {
                BFS_visited[i] = true;
                queue.push(i);
                BFS_answer.push(i);
            }
        }
    }
}

DFS(V);
BFS(V);

console.log(DFS_answer.join(" "));
console.log(BFS_answer.join(" "));