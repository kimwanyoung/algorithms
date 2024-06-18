// const input = require("fs").readFilsSync(0, "utf-8").trim().split("\n");

const input = ["5 17"];
const MAX = 100001;
const [n, k] = input[0].split(" ").map(Number);
const visited = Array(MAX).fill(0);

function bfs() {
    const queue = [];
    queue.push(n);

    while(queue.length !== 0) {
        let cur = queue.shift();
        if(cur === k) {
            return visited[cur];
        }
        for(let next of [cur - 1, cur + 1, cur * 2]) {
            if(next < 0 || next >= MAX) continue;
            if(visited[next] === 0) {
                visited[next] = visited[cur] + 1;
                queue.push(next);
            }
        }
    }
}

console.log(bfs());