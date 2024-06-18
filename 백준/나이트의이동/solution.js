/**
 나이트의 시작위치에서, 목표 지점까지 최단거리 구하는 문제.
 - 체스판 크기 * 체스판 크기의 2차원 배열 선언(visited), 0으로 초기화
 - 시작위치 queue에 삽입.
 - queue.length !== 0 이면, queue.shift()하고 인접 좌표 삽입
 - 방문처리 후 해당 좌표의 visitied는 이전 좌표의 값 + 1
 - 만약, 목표지점과 같다면 break.
 */

const input = require("fs").readFileSync(0, "utf-8").split("\n");
const testCase = Number(input[0]);
const chess = [];
for(let i = 1; i <= testCase * 3; i++) {
    chess.push(input[i]);
}

const dx = [-2, -2, -1, -1, 1, 1, 2, 2];
const dy = [-1, 1, -2, 2, -2, 2, -1, 1];

function solution(chess) {
    for(let i = 0; i < chess.length; i += 3) {
        const chessSize = Number(chess[i]);
        const current = chess[i + 1].split(" ").map(Number);
        const goal = chess[i + 2].split(" ").map(Number);
        const visited = []
        for(let i = 0 ; i < chessSize; i++) visited.push(new Array(chessSize).fill(0));

        bfs(visited, current, goal);
    }
}

function bfs(visited, current, goal) {
    const queue = [];
    queue.push(current);
    visited[current[0]][current[1]] = 1;

    while(queue.length !== 0) {
        const [x, y] = queue.shift();

        for(let i = 0 ; i < 8; i++){
            const ddx = x + dx[i];
            const ddy = y + dy[i];

            if(ddy < 0 || ddy > visited.length - 1) continue;
            if(ddx < 0 || ddx > visited.length - 1) continue;
            if(visited[ddx][ddy] === 0) {
                visited[ddx][ddy] = visited[x][y] + 1;
                queue.push([ddx, ddy]);
            }
        }
    }

    console.log(visited[goal[0]][goal[1]] - 1);
}

solution(chess);