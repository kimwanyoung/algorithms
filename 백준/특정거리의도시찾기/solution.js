/**
 * [solution]
 * - 인접 도시를 방문하며 시작 지점부터 거리를 누적해준다.
 * - 탐색이 끝나고 도시들을 순회히면서 거리가 K인 도시를 answer에 더해준다.
 * - answer 출력
 */

const input = [
    "4 4 2 1",
    "1 2",
    "1 3",
    "2 3",
    "2 4",
]

let [N, M, K, X] = input[0].split(" ").map(Number);
const graph = [];

for(let i = 1; i <= N ;i++) graph[i] = [];

for(let i = 1; i <= M; i++) {
    const [x, y] = input[i].split(" ").map(Number);
    graph[x].push(y);
}

function solution(N, M, K, X, graph) {
    const dist = new Array(N + 1).fill(-1);

    const queue = [];
    queue.push(X);
    dist[X] = 0;

    while (queue.length !== 0) {
        const node = queue.shift();
        for (const nextNode of graph[node]) {
            if (dist[nextNode] === -1) {
                dist[nextNode] = dist[node] + 1;
                queue.push(nextNode);
            }
        }
        if(dist[node] > K) break;
    }

    let check = false;
    for (let i = 1; i <= N; i++) {
        if (dist[i] === K) {
            console.log(i);
            check = true;
        }
    }

    if(!check) console.log(-1);
}

solution(N, M, K, X, graph);