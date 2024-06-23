const input = [
    "6",
    "5",
    "1 2",
    "1 3",
    "3 4",
    "2 3",
    "4 5",
]

/**
 * [solution]
 * - 상근이의 학번은 1번
 * - 초대받는 사람은 상근이의 친구와, 친구의 친구
 * - 즉, 1번 노드에서 거리가 2이내인 노드들만 초대를 받는다.
 * => 1번 노드에서 거리가 2이내인 노드의 개수를 구한다.
 */

const n = Number(input[0]);
const m = Number(input[1]);
const friends = [];

for(let i = 1; i <= n; i++) {
    friends[i] = [];
}

for(let i = 2; i < m + 2; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    friends[a].push(b);
    friends[b].push(a);
}


function bfs() {
    // 초대 인원 수
    let inviteCount = 0;
    const visited = new Array(n + 1).fill(false);
    const queue = [];

    //[1번(상근), 거리]를 queue에 넣고 bfs진행
    queue.push([1, 0]);
    visited[1] = true;

    while(queue.length !== 0) {
        const [number, distance] = queue.shift();

        // 인접 노드 확인
        for(const nextNumber of friends[number]) {
            // 거리에 1을 더해줬을 때 2보다 크다면 친구의 친구범위를 벗어나기 때문에 무시.
            if(distance + 1 > 2) continue;

            //방문하지 않았다면 방문체크 후 queue에 넣어준다.
            if(!visited[nextNumber]) {
                queue.push([nextNumber, distance + 1]);
                visited[nextNumber] = true;
                // 초대 가능한 인원이므로 inviteCount++;
                inviteCount++;
            }
        }
    }

    console.log(inviteCount);
}

bfs();