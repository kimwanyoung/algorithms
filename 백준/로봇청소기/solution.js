/**
 * [solution]
 * - input을 받고 로봇청소기의 초기 위치와 방향을 저장한다.
 *  - 방향은 0 : 북, 1: 동, 2: 남, 3: 서
 *  - 즉, 방향은 로봇이 다음 이동할 위치
 *  - 로봇청소기 위치에서 해당 방향으로 이동할 수 있도록 미리 방향 좌표 초기화
 *  - {0: [-1, 0], 1: [0, 1], 2: [1, 0], 3: [0, -1]}
 * - N * M의 방을 초기화
 * - 1. 현재 칸이 아직 청소되지 않았다면, 즉, 현재 위치 값이 0이라면 count++; -1로 값 변경
 * - 2. 주변 4방향 모두 0이 아닌경우 즉, 청소되지 않은 칸이 없다면
 *  - 2-1: 바라보는 방향은 유지하고 한칸 뒤로 ex 바라보는방향 0일떄 후진은2
 *  - 2-2: 후진할 위치가 벽이면 작동중지
 * - 3. 주변 4칸중 청소되지 않은 칸이 있으면
 *  - 3-1: 빈시계 방향으로 회전 currentDir -= 1; if(currentDir < 0) currentDir = 3;
 *  - 3-2: 회전 후 앞 방향이 청소되지 않은 빈칸이면 이동
 */

function solution(input) {
    const direction = {
        0: [-1, 0],
        1: [0, 1],
        2: [1, 0],
        3: [0, -1]
    }
    const room = [];
    let [robotY, robotX, dir] = input[1].split(" ").map(Number);
    let currentDir = dir;
    for(let i = 2; i < input.length; i++) {
        room.push(input[i].split(" ").map(Number));
    }

    let answer = 0;
    while(true) {
        if(room[robotY][robotX] === 0) {
            room[robotY][robotX] = -1;
            answer++;
        }

        let needClean = false;
        for(const dirKey in direction) {
            const [y, x] = direction[dirKey];
            if(room[robotY + y][robotX + x] === 0) {
                needClean = true;
            }
        }

        if(needClean) {
            if(currentDir === 0) currentDir = 3;
            else currentDir -= 1;

            const [y, x] = direction[currentDir];
            if(room[robotY + y][robotX + x] === 0) {
                robotY += y;
                robotX += x;
            }
        } else {
            const [y, x] = direction[currentDir];
            if(room[robotY - y][robotX - x] === 1) break;
            else {
                robotY -= y;
                robotX -= x;
            }
        }
    }

    return answer;
}

const input = [
    "11 10",
    "7 4 0",
    "1 1 1 1 1 1 1 1 1 1",
    "1 0 0 0 0 0 0 0 0 1",
    "1 0 0 0 1 1 1 1 0 1",
    "1 0 0 1 1 0 0 0 0 1",
    "1 0 1 1 0 0 0 0 0 1",
    "1 0 0 0 0 0 0 0 0 1",
    "1 0 0 0 0 0 0 1 0 1",
    "1 0 0 0 0 0 1 1 0 1",
    "1 0 0 0 0 0 1 1 0 1",
    "1 0 0 0 0 0 0 0 0 1",
    "1 1 1 1 1 1 1 1 1 1",
]

console.log(solution(input));