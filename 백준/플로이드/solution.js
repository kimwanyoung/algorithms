/**
 * [solution]
 * - 최단 경로 탐색 문제
 * 모든 노드의 최단거리를 구해야 하므로 플로이드 워셜 사용하면 해결 가능
 * 노드 = 도시, 버스 = 간선
 */
const input = [
    "5",
    "14",
    "1 2 2",
    "1 3 3",
    "1 4 1",
    "1 5 10",
    "2 4 2",
    "3 4 1",
    "3 5 1",
    "4 5 3",
    "3 5 10",
    "3 1 8",
    "1 4 2",
    "5 1 7",
    "3 4 2",
    "5 2 4",
]

const city = Number(input[0]);
const bus = Number(input[1]);

const graph = Array.from(Array(city + 1), () => new Array(city + 1).fill(Infinity));
for(let i = 2; i <= bus + 1; i++) {
    const [a, b, cost] = input[i].split(" ").map(Number);
    if(graph[a][b] !== Infinity) {
        graph[a][b] = Math.min(graph[a][b],cost);
    } else {
        graph[a][b] = cost;
    }
}

for(let i = 1; i <= city; i++) {
    graph[i][i] = 0;
}

for(let k = 1; k <= city; k++) {
    for(let a = 1; a <= city; a++) {
        for(let b = 1; b <= city; b++) {
            graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }
    }
}

let answer = "";
for(let i = 1; i <= city; i++) {
    for(let j = 1; j <= city; j++) {
        if(graph[i][j] === Infinity) answer += "0 ";
        else answer += graph[i][j] + " ";
    }
    answer += "\n";
}
console.log(answer);