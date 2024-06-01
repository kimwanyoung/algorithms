// const input = require("fs").readFileSync(0, "utf-8").split("\n");
/**
 * [solution]
 * - input을 받은 후 2차원 배열로 초기화한다.
 * - 초기화 하면서 미세먼지의 위치 정보를 저장해놓는다.
 * - 공기청정기의 위 부분 위치와 아래부분 위치를 저장해놓는다.
 * - T초가 되기 전까지 아래의 행위를 반복한다.
 *  - 저장해 놓은 미세먼지의 위치들의 개수만큼 반복
 *      - 해당 위치의 미세먼지값 / 5를 한 값을 4방향에 더해주고, 확산 된 만큼 기존 미세먼지양에서 빼준다.
 *      - 만약, 확산되는 위치가 벽이거나, 공기청정기가 있다면 확산되지 않는다.
 *      - 확산된 위치도 미세먼지 위치 정보에 저장해놓는다.
 *  - 공기 청정기 작동
 *      - 저장해 놓은 미세먼지들의 위치를 한칸씩 이동시킨다.
 *      - (r, c) r이 공기청정기의 위치보다 작으면 반시계방향 (r, c) = (r, c + 1)
 *      - r === 0, (r, c - 1)
 *      - c === C, (r - 1, c)
 *      - r === 0 && c === C, (r, c - 1)
 *      - r === 0 && c === 0 , (r + 1, c)
 *      - 이동거리가 공기청정기의 위치라면, 미세먼지는 사라진다.
 *      - 아래부분일 경우는 위 조건 반대
 */
const input = [
    "7 8 1",
    "0 0 0 0 0 0 0 9",
    "0 0 0 0 3 0 0 8",
    "-1 0 5 0 0 0 22 0",
    "-1 8 0 0 0 0 0 0",
    "0 0 0 0 0 10 43 0",
    "0 0 5 0 15 0 0 0",
    "0 0 40 0 0 0 20 0",
]

// [0, -1] [0, 1] [1, 0] [-1, 0]
function solution(input) {
    let [R, C, T] = input[0].split(" ").map(Number);
    input = input.slice(1).map((v) => v.split(" ").map(Number));
    let answer = 0;
    let upperCleaner = [0, 0];
    let lowerCleaner = [0, 0];
    let flag = false;
    const dx = [1, 0, -1, 0];
    const dy = [0, 1, 0, -1];

    // 미세먼지 확산
    function spreadDust() {
        for (let row = 0; row < R; row++) {
            for (let col = 0; col < C; col++) {
                if (input[row][col] > 0) {
                    let spreadCount = 0;
                    const value = Math.floor(input[row][col] / 5);
                    for (let i = 0; i < 4; i++) {
                        const [nRow, nCol] = [row + dx[i], col + dy[i]];
                        if (nRow < 0 || nRow >= R || nCol < 0 || nCol >= C || input[nRow][nCol] === -1) continue;
                        input[nRow][nCol] += value;
                        spreadCount++;
                    }
                    input[row][col] -= (value * spreadCount);
                    spreadCount = 0;
                }
            }
        }
    }

    // 위쪽 공기청정기 순환 (반시계방향)
    function rotateUp(cleanerRow) {
        for (let row = cleanerRow - 2; row >= 0; row--) {
            input[row + 1][0] = input[row][0];
        }

        for (let col = 1; col < C; col++) {
            input[0][col - 1] = input[0][col];
        }

        for (let row = 1; row <= cleanerRow; row++) {
            input[row - 1][C - 1] = input[row][C - 1];
        }

        for (let col = C - 2; col > 0; col--) {
            input[cleanerRow][col + 1] = input[cleanerRow][col];
        }

        input[cleanerRow][1] = 0;
    }

    // 아래쪽 공기청정기 순환 (시계방향)
    function rotateDown(cleanerRow) {
        for (let row = cleanerRow + 2; row < R; row++) {
            input[row - 1][0] = input[row][0];
        }

        for (let col = 1; col < C; col++) {
            input[R - 1][col - 1] = input[R - 1][col];
        }

        for (let row = R - 2; row >= cleanerRow; row--) {
            input[row + 1][C - 1] = input[row][C - 1];
        }

        for (let col = C - 2; col > 0; col--) {
            input[cleanerRow][col + 1] = input[cleanerRow][col];
        }

        input[cleanerRow][1] = 0;
    }

    // 남아있는 미세먼지 양 계산
    function countDust() {
        let result = 0;
        for (let row = 0; row < R; row++) {
            for (let col = 0; col < C; col++) {
                if (input[row][col] > 0) result += input[row][col];
            }
        }
        return result;
    }

    // 공기 청정기 위치 찾기
    for (let row = 0; row < R; row++) {
        for (let col = 0; col < C; col++) {
            if (input[row][col] === -1) {
                upperCleaner = row;
                lowerCleaner = row + 1;
                flag = true;
                break;
            }
        }
        if (flag) break;
    }

    // T 만큼 진행 (확산 -> 위쪽 순환 -> 아래쪽 순환)
    while (T--) {
        spreadDust();
        rotateUp(upperCleaner);
        rotateDown(lowerCleaner);
    }

    answer = countDust();
    return answer;
}

console.log(solution(input));