/**
 * [solution]
 * - 톱니바퀴를 배열에 초기화 시킨다. => initializeGears
 * - input으로 들어온 회전 횟수만큼 반복문 실행
 * - 시계방향 rotateClockwise
 *  - 새로운 배열을 선언하고 시계방향으로 회전시켰을 때의 상태를 저장 후 반환한다.
 * - 반시계방향 rotateCounterClockwise
 *  - 시계방향의 반대로 구현
 *  - 인접 톱니중, 다른 극을 갖고 있는 톱니가 있다면, 반대 방향으로 회전, 재귀로 인접 톱니 확인
 *
 */

function solution(input) {
    const rotateCount = Number(input[4]);
    const gears = [];
    for(let i = 0; i < 4; i++) {
        gears.push(initializeGears(input[i]));
    }

    for(let i = 5; i < rotateCount + 5; i++) {
        const [gearIdx, rotateDirection] = input[i].split(" ").map(Number);
        let left = [];
        let right = [];
        checkLeft(gears, gearIdx - 1, left);
        checkRight(gears, gearIdx - 1, right);

        if(rotateDirection > 0) {
            rotateClockwise(gears, gearIdx - 1);
        } else {
            rotateCounterClockwise(gears, gearIdx - 1);
        }

        let tempDirection = rotateDirection;
        for(let i = 0; i < left.length; i++) {
            tempDirection = -tempDirection;
            rotate(gears, left[i], tempDirection);
        }

        tempDirection = rotateDirection;
        for(let i = 0; i < right.length; i++) {
            tempDirection = -tempDirection;
            rotate(gears, right[i], tempDirection);
        }
    }

    return parseInt(gears[3][0] + gears[2][0] + gears[1][0] + gears[0][0], 2);
}

function rotate(gears, gearIdx, direction) {
    if(direction === 1) {
        rotateClockwise(gears, gearIdx);
    } else {
        rotateCounterClockwise(gears, gearIdx);
    }
}

function checkLeft(gears, gearIdx, rotate) {
    if(gearIdx < 1) {
        return rotate;
    }
    if(gears[gearIdx][6] !== gears[gearIdx - 1][2]) {
        rotate.push(gearIdx - 1);
        return checkLeft(gears, gearIdx - 1, rotate);
    }
    return rotate;
}

function checkRight(gears, gearIdx, rotate) {
    if(gearIdx > 2) {
        return rotate;
    }
    if(gears[gearIdx][2] !== gears[gearIdx + 1][6]) {
        rotate.push(gearIdx + 1);
        return checkRight(gears, gearIdx + 1, rotate);
    }
    return rotate;
}

function rotateClockwise(gears, gearIdx) {
    gears[gearIdx].unshift(gears[gearIdx].pop());
}

function rotateCounterClockwise(gears, gearIdx) {
    gears[gearIdx].push(gears[gearIdx].shift());
}

function initializeGears(gearString) {
    return gearString.split("");
}

const input = [
    "10101111",
    "01111101",
    "11001110",
    "00000010",
    "2",
    "3 -1",
    "1 1",
]

console.log(solution(input));
