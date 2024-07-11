/**
 * [solution]
 * 전형적인 벨만포드 문제
 * 노드 사이의 거리가 음수인 경우도 있기 때문에 벨만포드 알고리즘으로 해결할 수 있다.
 * 이동 시간이 음수이면 시간은 되돌리는 것이다.
 * 무한히 시간을 되돌리는 경우 => 음의 순환이 존재할 수 있다. 이 경우에는 -1을 출력한다.
 * 음의 순환이 존재하지 않고 이동할 수 없다면 -1
 * 그 외는 최단 거리를 출력한다.
 */
const input = [
    "3 4",
    "1 2 4",
    "1 3 3",
    "2 3 -4",
    "3 1 -2",
]

const [n, m] = input[0].split(" ").map(Number);
const dist = new Array(n + 1).fill(Infinity);

const negativeCycle = bf(1);
if(negativeCycle) console.log(-1);
else {
    for(let i = 2; i <= n; i++) {
        if(dist[i] === Infinity) console.log(-1);
        else console.log(dist[i]);
    }
}

function bf(start) {
    dist[start] = 0;
    for(let i = 1; i <= n; i++) {
        for(let j = 1; j <= m; j++) {
            const [current, next, cost] = input[j].split(" ").map(Number);
            if(dist[current] !== Infinity && dist[next] > dist[current] + cost) {
                dist[next] = dist[current] + cost;

                if(i === n) return true;
            }
        }
    }
    return false;
}
