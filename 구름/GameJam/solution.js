const readline = require('readline');

(async () => {
    let rl = readline.createInterface({ input: process.stdin });

    const input = [];
    for await (const line of rl) {
        input.push(line);
    }
    rl.close();

    const [boardSize, goormPosition, playerPosition, ...commands] = input;
    solution(Number(boardSize), goormPosition, playerPosition, commands);

    process.exit();
})();

function solution(boardSize, goormPosition, playerPosition, commands) {
    const goormBoard = initializeBoard(boardSize);
    const playerBoard = initializeBoard(boardSize);

    goormPosition = goormPosition.split(" ").map((p) => p - 1);
    playerPosition = playerPosition.split(" ").map((p) => p - 1);

    const goormScore = playGame(goormBoard, goormPosition, commands);
    const playerScore = playGame(playerBoard, playerPosition, commands);

    const winner = goormScore > playerScore ? "goorm" : "player";
    if(winner === "goorm") console.log(winner + " " + goormScore)
    else console.log(winner + " " + playerScore);
}

function playGame(board, position, commands) {
    const gameBoard = board;
    const direction = {
        L: [0, -1],
        R: [0, 1],
        D: [1, 0],
        U: [-1, 0],
    }

    let [y, x] = position;
    commands = commands.map((command) => command.split(" "));


    let flag = true;
    let score = 1;
    while(flag) {
        gameBoard[y][x] = true;
        const command = commands[y][x].at(-1);
        const step = commands[y][x].substring(0, commands[y][x].length-1);

        for(let i = 0; i < Number(step); i++) {
            const [dy, dx] = direction[command];

            y += dy;
            x += dx;
            if(y > board.length - 1) y = 0;
            if(y < 0) y = board.length - 1;
            if(x > board.length - 1) x = 0;
            if(x < 0) x = board.length - 1;

            if(!gameBoard[y][x]) {
                score++;
                gameBoard[y][x] = true;
            }else {
                flag = false;
                break;
            }
        }
    }

    return score;
}

function initializeBoard(boardSize) {
    return Array.from({length: boardSize}, () => Array.from({length: boardSize}, () => false));
}