// Run by Node.js

const readline = require("readline");

(async () => {
    let rl = readline.createInterface({ input: process.stdin });
    const input = [];

    for await (const line of rl) {
        input.push(line);
    }
    rl.close();

    const [N, max, board, K] = input;
    solution(N, max, board, K);
    process.exit();
})();

function solution(N, max, board, K) {
    N = Number(N);
    max = max.split(" ").map(Number);
    board = board.split(" ").map(Number);

    while(K > 0) {
        let currentIdx = N - 1;
        board[currentIdx]++;

        while(board[currentIdx] > max[currentIdx]) {
            board[currentIdx] = 0;
            if(currentIdx < 0) break;
            board[currentIdx - 1]++;
            currentIdx--;
        }

        K--;
    }


    console.log(board.join(""));
}