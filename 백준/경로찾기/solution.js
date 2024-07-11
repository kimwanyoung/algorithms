/**
 * [solution]
 * 모든 정점의 최단 경로 구하기 양수인 경로가 있으면 1출력, 그렇지 않으면 0출력 즉, 무한대이면 0출력
 * 노드 개수의 범위는 100이므로 O(n3)인 플로이드 워셜로 해결가능
 */

const input = [
    "3",
    "0 1 0",
    "0 0 1",
    "1 0 0",
]

const n = Number(input[0]);
const graph = Array.from(Array(n + 1), () => new Array(n + 1).fill(Infinity));

for(let i = 1; i <= n; i++) {
    const line = input[i].split(" ").map(Number);
    for(let j = 0; j < n; j++) {
        if(line[j] === 1) graph[i][j + 1] = 1;
    }
}

for(let k = 1; k <= n; k++) {
    for(let a = 1; a <= n; a++) {
        for(let b = 1; b <= n; b++) {
            graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }
    }
}

let answer = "";
for(let i = 1; i <= n; i++) {
    for(let j = 1; j <= n; j++) {
        if(graph[i][j] === Infinity) answer += "0 ";
        else answer += "1 ";
    }
    answer += "\n";
}

console.log(answer);