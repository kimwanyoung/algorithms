const input = require('fs')
    .readFileSync(0, 'utf-8')
    .toString()
    .trim()
    .split('\n')
    .map((v) => v.trim().split(' ').map(Number));

const [M, S] = input.shift();

let board = Array.from(Array(4), () => Array.from(Array(4), () => []));

const dx = [0, -1, -1, -1, 0, 1, 1, 1];
const dy = [-1, -1, 0, 1, 1, 1, 0, -1];

const sdx = [-1, 0, 1, 0];
const sdy = [0, -1, 0, 1];

for (let i = 0; i < M; i++) {
    const [fx, fy, d] = input.shift().map((v) => v - 1);
    board[fx][fy].push(d);
}
let [sx, sy] = input.shift().map((v) => v - 1);

let fishSmell = Array.from(Array(4), () => Array(4).fill(0));

for (let practice = 0; practice < S; practice++) {
    // 복제마법쓰기
    const duplicatedFish = [];
    for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 4; j++) {
            for (let k = 0; k < board[i][j].length; k++) {
                duplicatedFish.push([i, j, board[i][j][k]]);
            }
        }
    }

    // 물고기 이동하기
    let newBoard = Array.from(Array(4), () => Array.from(Array(4), () => new Array()));
    duplicatedFish.forEach((fish) => {
        const [fx, fy, d] = fish;
        let haveMoved = false;
        for (let k = 0; k < 8; k++) {
            const fk = d - k < 0 ? 8 + (d - k) : d - k;
            const nx = fx + dx[fk];
            const ny = fy + dy[fk];
            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
            if (nx == sx && ny == sy) continue;
            if (fishSmell[nx][ny] > 0) continue;

            newBoard[nx][ny].push(fk);
            haveMoved = true;
            break;
        }

        if (!haveMoved) {
            newBoard[fx][fy].push(d);
        }
    });
    // 상어 이동하기
    let max = -1;
    let path = [];
    for (let i = 0; i < 4; i++) {
        const nsx = sx + sdx[i];
        const nsy = sy + sdy[i];
        if (nsx < 0 || nsy < 0 || nsx >= 4 || nsy >= 4) continue;
        const fishI = newBoard[nsx][nsy].length;
        for (let j = 0; j < 4; j++) {
            const nnsx = nsx + sdx[j];
            const nnsy = nsy + sdy[j];
            if (nnsx < 0 || nnsy < 0 || nnsx >= 4 || nnsy >= 4) continue;
            const fishJ = newBoard[nnsx][nnsy].length;
            for (let k = 0; k < 4; k++) {
                const nnnsx = nnsx + sdx[k];
                const nnnsy = nnsy + sdy[k];
                if (nnnsx < 0 || nnnsy < 0 || nnnsx >= 4 || nnnsy >= 4) continue;

                const fishK = nnnsx === nsx && nnnsy === nsy ? 0 : newBoard[nnnsx][nnnsy].length;

                const fishTotal = fishI + fishJ + fishK;
                if (fishTotal > max) {
                    max = fishTotal;
                    path = [i, j, k];
                }
            }
        }
    }

    path.forEach((k) => {
        sx = sx + sdx[k];
        sy = sy + sdy[k];
        if (newBoard[sx][sy].length > 0) fishSmell[sx][sy] = 3;
        newBoard[sx][sy] = [];
    });
    // 2턴전 물고기 냄새 사라짐

    for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 4; j++) {
            if (fishSmell[i][j] > 0) fishSmell[i][j]--;
        }
    }

    //복제하기
    duplicatedFish.forEach((fish) => {
        const [fx, fy, d] = fish;
        newBoard[fx][fy].push(d);
    });
    board = newBoard;
}
let answer = 0;
for (let i = 0; i < 4; i++) {
    for (let j = 0; j < 4; j++) {
        answer += board[i][j].length;
    }
}

console.log(answer);