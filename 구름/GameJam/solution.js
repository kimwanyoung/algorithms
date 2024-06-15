const readline = require('readline');

// (async () => {
//     let rl = readline.createInterface({ input: process.stdin });
//
//     const input = [];
//     for await (const line of rl) {
//         input.push(line);
//         rl.close();
//     }
//
//     const [boardSize, goormPosition, playerPosition, ...commands] = input;
//     solution(Number(boardSize), goormPosition, playerPosition, commands);
//
//     process.exit();
// })();

function solution(boardSize, goormPosition, playerPosition, commands) {
    const goormBoard = createBoard(+boardSize);
    const playerBoard = createBoard(+boardSize);
    const commandBoard = commands.map((command) => command.split(" "));

    const [gy, gx] = goormPosition.split(" ").map(Number);
    const [py, px] = playerPosition.split(" ").map(Number);

    const goormScore = playGame(gy - 1, gx - 1, goormBoard, commandBoard);
    const playerScore = playGame(py - 1, px - 1, playerBoard, commandBoard);

    const winner = goormScore > playerScore ? "goorm" : "player";
    if(winner === "goorm") console.log(winner + " " + goormScore);
    else console.log(winner + " " + playerScore);
}

function createBoard(boardSize) {
    return Array.from(Array(boardSize), () => new Array(boardSize).fill(false));
}

function playGame(y, x, board, commands) {
    const commandType = ["U", "D", "R", "L"];
    const dy = [1, -1, 0, 0];
    const dx = [0, 0, 1, -1];

    let flag = true;
    while(flag) {
        board[y][x] = true;

        const [count, command] = commands[y][x].split("");

        for(let i = 0; i < Number(count); i++) {
            const direction = commandType.indexOf(command);
            y += dy[direction];
            x += dx[direction];

            if(y > board.length - 1) y = 0;
            if(y < 0) y = board.length - 1;
            if(x > board.length - 1) x = 0;
            if(x < 0) x = board.length - 1;

            if(board[y][x]) {
                flag = false;
                break;
            }
        }
    }

    return board.flat().reduce((cnt, element) => cnt + element, 0);
}
const input =["4",
    "4 2",
    "2 4",
    "1L 3D 3L 1U",
    "2D 2L 4U 1U",
    "2D 2L 4U 3L",
    "4D 4D 1R 4R"];
const [boardSize, goormPosition, playerPosition, ...commands] = input;

solution(boardSize, goormPosition, playerPosition, commands);