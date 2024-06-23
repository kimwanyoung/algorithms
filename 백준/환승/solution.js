/**
 *  [solution]
 *  인접 노드들을 배열로 표시한 후 1번 부터 bfs를 진행해서 N번까지의 최소거리 구하기
 *
 */

const input = [
    "15 8 4",
    "11 12 8 14 13 6 10 7",
    "1 5 8 12 13 6 2 4",
    "10 15 4 5 9 8 14 12",
    "11 12 14 3 5 6 1 13",
]

const [N, K, M] = input[0].split(" ").map(Number);
const graph = [];
for(let i = 1; i <= N + M; i++) graph[i] = [];
for(let i = 1; i <= M; i++) {
    const arr = input[i].split(" ").map(Number);
    for(const x of arr) {
        graph[x].push(N + i);
        graph[N + i].push(x);
    }
}

function solution(N, K, M, graph) {
    const visited = new Set([1]);
    const queue = [];
    queue.push([1, 1]);
    let found = false;

    while(queue.length !== 0) {
        const [now ,distance] = queue.shift();

        if(now === N) {
            console.log(Math.floor(distance / 2) + 1);
            found = true;
            break;
        }

        for(const y of graph[now]) {
            if(!visited.has(y)) {
                queue.push([y, distance + 1]);
                visited.add(y);
            }
        }
    }

    if(!found) console.log(-1);
}

solution(N, K, M, graph);