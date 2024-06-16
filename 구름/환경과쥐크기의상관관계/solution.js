// Run by Node.js
const readline = require('readline');

(async () => {
    let rl = readline.createInterface({input: process.stdin});
    const input = [];

    for await (const line of rl) {
        input.push(line);
    }
    rl.close();

    const [N, A, B] = input;
    solution(N, A, B);
    process.exit();
})();


// 정렬 후 최소값 + 2 부터, 최대값 -2까지를 X로 할당하고 가장 많은 개수를 구한다.
function solution(N, A, B) {
    const good = calculateValue(A.split(" ").map(Number));
    const bad = calculateValue(B.split(" ").map(Number));

    console.log(good, bad);
    console.log(good > bad ? "good" : "bad");
}

function calculateValue(space) {
    space.sort((a, b) => a - b);

    let max = 0;
    let res = 0;
    for (let i = 0, j = 0; i < space.length; i++) {
        if (space[i] - space[j] > 4) j++;
        else {
            let cnt = i - j + 1;
            if (cnt > max) {
                max = cnt;
                res = Math.floor((space[i] + space[j]) / 2);
            }
        }
    }

    return res;
}
