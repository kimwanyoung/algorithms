/**
 * [solution]
 * - input이 "0 0"이 될 때까지 반복문 실행
 * - 지뢰밭을 2차원 배열로 선언 후 input을 읽으며 초기화
 * - 답으로 제출할 새로운 배열 선언 후 위에서 초기화한 지뢰밭을 순회하면서 8방향 확인
 */

// const input = require("fs").readFileSync(0, "utf-8").split("\n");

const input = [
    "3 2",
    "..",
    ".*",
    "..",
    "5 5",
    "*.*.*",
    "..*..",
    "*****",
    ".....",
    "..**.",
    "0 0",
]

const move = [[0, 1], [1, 0], [1, 1], [-1, 0], [-1, 1], [-1, -1], [0, -1], [1, -1]];
let answerString = "";

let i = 0;
while (input[i] !== "0 0") {
    const [maxY, maxX] = input[i].split(" ").map(Number);
    const minefield = [];

    for(let j = 1; j <= maxY; j++){
        const mines = input[j + i].split("");
        minefield.push(mines);
    }
    i += maxY + 1;

    let answer = [];
    minefield.forEach((mines, y) => {
        let temp = [];
        mines.forEach((mine, x) => {
            if(mine === "*") {
                temp.push("*");
            } else {
                let mineCnt = 0;
                for(let k = 0; k < 8; k++) {
                    const [moveY, moveX] = move[k];
                    const movedY = y + moveY;
                    const movedX = x + moveX;
                    if(0 <= movedY && movedY < maxY && 0 <= movedX && movedX < maxX) {
                        if(minefield[movedY][movedX] === "*") {
                            mineCnt++;
                        }
                    }
                }
                temp.push(mineCnt);
            }
        })
        answer.push(temp);
    })
    answer.forEach((answers) => {
        answers.forEach((a) => {
            answerString += a;
        })
        answerString += "\n";
    })
}

console.log(answerString);
