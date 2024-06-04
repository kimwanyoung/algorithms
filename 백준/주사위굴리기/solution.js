/**
 * [solution]
 * - input에서 들어온 지도를 배열에 저장해놓는다.
 * - 초기 주사위는 [0 0 0 0 0 0]
 * - [뒤, 왼, 위, 오, 앞, 아래]
 * - 명령만큼 주사위를 굴린다. (명령 => 동: 1, 서: 2, 북: 3, 남: 4)
 *  - 만약, 주사위를 굴렸을 때 지도의 숫자가 0이면, 주사위의 바닥면에 쓰여있는 수가 복사된다.
 *  - 만약, 지도의 숫자가 0이 아니라면, 지도의 숫자는 0으로 바뀌고 주사위의 바닥면으로 복사된다.
 *  - 이동할 때마다. answer에 현재 주사위의 맨 상단 숫자를 저장한다.
 * - answer반환
 */

function solution(input) {
    let answer = "";
    let [y, x, diceY, diceX, commandCount] = input[0].split(" ").map(Number);
    const commands = input[y + 1].split(" ").map(Number);
    const map = [];

    for(let i = 1; i <= y; i++){
        map.push(input[i].split(" ").map(Number));
    }

    const DICE_TOP_INDEX = 2;
    const DICE_BOTTOM_INDEX = 5;
    const dy = [0, 0, 0, -1, 1];
    const dx = [0, 1, -1, 0, 0];
    let dice = [0, 0, 0, 0, 0, 0];

    let i = 0;
    while(i < commandCount) {
        const command = commands[i];
        const afterY = diceY + dy[command];
        const afterX = diceX + dx[command];

        if(0 <= afterY && afterY < y && 0 <= afterX && afterX < x) {
            dice = rollDice(dice, command);

            if(map[afterY][afterX] === 0) {
                map[afterY][afterX] = dice[DICE_BOTTOM_INDEX];
            } else {
                dice[DICE_BOTTOM_INDEX] = map[afterY][afterX];
                map[afterY][afterX] = 0;
            }

            diceY = afterY;
            diceX = afterX;

            answer += dice[DICE_TOP_INDEX] + "\n";
        }
        i++;
    }

    return answer;
}

function rollDice(dice, direction) {
    if(direction === 1) {
        return [dice[0], dice[5], dice[1], dice[2], dice[4], dice[3]];
    }
    if(direction === 2) {
        return [dice[0], dice[2], dice[3], dice[5], dice[4], dice[1]]
    }
    if(direction === 3) {
        return [dice[2], dice[1], dice[4], dice[3], dice[5], dice[0]];
    }
    if(direction === 4) {
        return [dice[5], dice[1], dice[0], dice[3], dice[2], dice[4]];
    }
}

const input = require("fs").readFileSync(0, "utf-8").split("\n");
console.log(solution(input));
