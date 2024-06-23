const input = [
    "9 3 5",
    "1 2 3",
    "1 4 5",
    "3 6 7",
    "5 6 7",
    "6 8 9",
]

/**
 * [solution]
 * - 하이퍼튜브는 주어진 역을 연결한다. => 하이퍼튜브 노드도 따로 만든다.
 * - 1번 노드부터 bfs를 진행하고, N 역까지 도달했을 때의 거쳐간 역을 구한다.
 * - 하이퍼 튜브도 포함한 역의 개수이므로 2로 나눠준다.
 * - 거리가 아닌 거쳐간 역이므로 처음 출발한 1번 역도 더해준다 +1
 * - 만약, 갈 수 없는 역이라면 -1을 출력해준다.
 */
const [N, K, M] = input[0].split(" ").map(Number);
const graph = Array.from(Array(N + M + 1), () => []);
for(let i = 1; i <= M; i++) {
    const stations = input[i].split(" ").map(Number);
    for(const station of stations) {
        //해당 역에 하이퍼 튜브도 추가
        graph[station].push(N + i);
        // 양방향 연결이기 때문에, 하이퍼 튜브에도 역을 추가해준다.
        graph[N + i].push(station);
    }
}

function bfs() {
    const visited = new Set([1]);
    const queue = [];
    // [node, distance]
    queue.push([1, 0]);

    // 길을 찾았는지 확인하는 변수
    let found = false;
    while(queue.length !== 0) {
        const [currentStation, distance] = queue.shift();
        if(currentStation === N) {
            // 하이퍼튜브 포함인 개수이기 때문에 나누기 2를 해준다.
            // 출발역 포함이기 때문에, 거리 +1해준다.
            console.log(Math.floor(distance / 2) + 1);
            //찾았다면, found = true로 업데이트
            found = true;
            break;
        }

        for(const nextStation of graph[currentStation]) {
            //방문처리가 안되어있다면,
            if(!visited.has(nextStation)) {
                // 다음 역은 현재 거리에서 +1 해준상태로 queue에 넣어준다.
                queue.push([nextStation, distance + 1]);

                //방문처리
                visited.add(nextStation);
            }
        }
    }
    if(!found) console.log(-1);
}

bfs();