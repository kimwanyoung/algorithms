/**
 * [solution]
 * - 상태값을 [0, 0]으로 초기화한다.
 * - dirs를 순회 하면서 각 방향에 맞게 좌표 값을 더해준다.
 *  - 만약, 범위를 벗어난다면 명령 무시
 * - 이동 방향을 set에 더해준다.
 * - 양방향 이동을 더해줬기 때문에 size / 2 반환.
 */

const solution = (dirs) => {
    const direction = {
        U: [0, 1],
        D: [0, -1],
        L: [-1, 0],
        R: [1, 0],
    };
    let character = [0, 0];
    const answer = new Set();

    for(let i = 0 ; i < dirs.length; i++) {
        const [x, y] = direction[dirs[i]];
        const [beforeMoveX, beforeMoveY] = character;
        const [moveX, moveY] = [beforeMoveX + x, beforeMoveY + y];

        if(moveX < -5 || moveX > 5 || moveY < -5 || moveY > 5) continue;
        character = [moveX, moveY];

        answer.add(`[${beforeMoveX},${beforeMoveY}] => [${moveX},${moveY}]`);
        answer.add(`[${moveX},${moveY}] => [${beforeMoveX},${beforeMoveY}]`);
    }

    return answer.size / 2;
}