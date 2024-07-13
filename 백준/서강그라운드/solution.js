/**
 * [solution]
 * - 모든 노드에서 모든 노드까지의 최단거리를 구해야하므로 플로이드 워셜이 적절하다.
 * - 플로이드 워셜로 최단거리를 다 구한 후 반복문을 돌면서 수색범위 보다 좁은 노드들을 체크한다.
 * - 그 후 체크 된 노드들의 아이템 개수를 누적합해서 반환한다.
 */

const input = [
    "5 5 4",
    "5 7 8 2 3",
    "1 4 5",
    "5 2 4",
    "3 2 3",
    "1 2 3",
]

const [n, m, r] = input[0].split(" ").map(Number);
const items = input[1].split(" ").map(Number);
const graph = Array.from(Array(n + 1), () => new Array(n + 1).fill(Infinity));

for(let i = 2; i < r + 2; i++) {
    const [a, b, dist] = input[i].split(" ").map(Number);
    if(graph[a][b] !== Infinity && graph[b][a] !== Infinity) {
        graph[a][b] = Math.min(graph[a][b], dist);
        graph[b][a] = Math.min(graph[b][a], dist);
    } else {
        graph[a][b] = dist;
        graph[b][a] = dist;
    }
}

for(let i = 1; i <= n; i++) graph[i][i] = 0;

for(let k = 1; k <= n; k++) {
    for(let a = 1; a <= n; a++) {
        for(let b = 1; b <= n; b++) {
            graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }
    }
}

let sum = 0;
for(let i = 1; i <= n; i++) {
    let temp = 0;
    for(let j = 1; j <= n; j++) {
        if(graph[i][j] <= m) {
            temp += items[j - 1];
        }
    }
    sum = Math.max(sum, temp);
}

console.log(sum);