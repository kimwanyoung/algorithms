const input = [
    "2",
    "3 2",
    "1 3",
    "2 3",
    "4 4",
    "1 2",
    "2 3",
    "3 4",
    "4 2",
]
function bfs(x, graph, visited) {
    const queue = [];
    queue.push(x);
    visited[x] = 0;
    while(queue.length !== 0) {
        x = queue.shift();
        for(const y of graph[x]) {
            if(visited[y] === -1) {
                visited[y] = (visited[x] + 1) % 2;
                queue.push(y);
            }
        }
    }
}

function isBipartite(graph, visited) {
    for(let x = 1; x < visited.length; x++) {
        for (let y of graph[x]) if(visited[x] === visited[y]) return false;
    }
    return true;
}

let testCase = Number(input[0]);
let line = 1;
while(testCase--) {
    let [v, e] = input[line].split(" ").map(Number);
    let graph = [];
    for(let i = 1; i <= v; i++) {
        graph[i] = [];
    }
    for(let i = 1; i <= e; i++) {
        const [u, v] = input[line + i].split(" ").map(Number);
        graph[u].push(v);
        graph[v].push(u);
    }

    const visited = new Array(v + 1).fill(-1);
    for(let i = 1; i <= v; i++) {
        if(visited[i] === -1) {
            bfs(i, graph, visited);
        }
    }

    line += e + 1;
    if(isBipartite(graph, visited)) console.log("Yes");
    else console.log("No");
}