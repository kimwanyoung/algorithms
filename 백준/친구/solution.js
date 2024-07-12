/**
 * [solution]
 * 각 사람들이 노드.
 * 각 노드들의 인접한 수가 가장 많은 수
 * 즉, 각 노드들로부터 모든 거리를 구하고 각 노드들끼리의 거리가 2 이하인 노드들의 개수를 구하는 문제.
 * 플로이드-워셜 알고리즘으로 해결가능
 */

const input = [
    "10",
    "NNNNYNNNNN",
    "NNNNYNYYNN",
    "NNNYYYNNNN",
    "NNYNNNNNNN",
    "YYYNNNNNNY",
    "NNYNNNNNYN",
    "NYNNNNNYNN",
    "NYNNNNYNNN",
    "NNNNYNNNNN",
    "NNNNNYNNNN",
]

const n = Number(input[0]);
const graph = [];
for(let i = 1; i <= n; i++) {
    const line = input[i].split("");
    const temp = [];
    for(let j = 0; j < n; j++) {
        if(line[j] === "Y") temp.push(1);
        else temp.push(Infinity);
    }
    graph.push(temp);
}

for(let i = 0; i < n; i++) {
    graph[i][i] = 0;
}

for(let k = 0; k < n; k++) {
    for(let a = 0; a < n; a++) {
        for(let b = 0; b < n; b++) {
            graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }
    }
}


const friends = new Array(n).fill(0);
for(let i = 0; i < n; i++) {
    for(let j = 0; j < n; j++) {
        if(i !== j && graph[i][j] <= 2) friends[i]++;
    }
}

console.log(Math.max(...friends));