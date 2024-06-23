const input = [
    "8 9",
    "0 0 0 0 0 0 0 0 0",
    "0 0 0 1 1 0 0 0 0",
    "0 0 0 1 1 0 1 1 0",
    "0 0 1 1 1 1 1 1 0",
    "0 0 1 1 1 1 1 0 0",
    "0 0 1 1 0 1 1 0 0",
    "0 0 0 0 0 0 0 0 0",
    "0 0 0 0 0 0 0 0 0",
]

const [n, m] = input[0].split(" ").map(Number);
const graph = []
for(let i = 1; i <= n; i++) {
    graph.push(input[i].split(" ").map(Number));
}

const dy = [-1, 1, 0, 0];
const dx = [0, 0, -1, 1];

function bfs(n, graph) {
    const visited = [];
    for(let i = 0; i < n; i++) visited.push(new Array(m).fill(false));
    visited[0][0] = true;
    const queue = [];
    queue.push([0, 0]);

    while(queue.length !== 0) {
        const [x, y] = queue.shift();

        //4방향을 확인한다.
        for(let i = 0; i < 4; i++) {
            const nx = x + dx[i];
            const ny = y + dy[i];

            //범위를 벗어나면 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            // 방문처리가 되지 않았다면,
            if(!visited[nx][ny]) {
                //그리고 치즈가 존재한다면 치즈에 +1해준다. (bfs처리가 끝난 후 치즈의 크기가 3이상이면 바깥쪽과 닿아있는 면이 2개 이상임을 체크하기 위해)
                if(graph[nx][ny] >= 1) graph[nx][ny] += 1;
                else {
                    // 치즈가 없다면 queue에 넣어준다. (바깥쪽 면만 탐색해서 치즈와 닿아있는 부분만 체크)
                    queue.push([nx, ny]);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

function melt() {
    let finish = true;
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            // 맞닿은 면이 2개 이상이면 0으로 처리(녹인다.)
            if(graph[i][j] >= 3) {
                graph[i][j] = 0;
                finish = false;
                // 2라면 맞닿은 면이 1개이므로 다시 1로 업데이트
            } else if(graph[i][j] === 2) graph[i][j] = 1;
        }
    }

    // 녹인 치즈가 없을 때까지
    return finish;
}

let result = 0;
while(true) {
    bfs(n, graph);
    if(melt()) {
        console.log(result);
        break;
    }
    else result += 1;
}