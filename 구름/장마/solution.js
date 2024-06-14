// Run by Node.js
// const readline = require('readline');
// const input = [];
//
// (async () => {
//     let rl = readline.createInterface({ input: process.stdin });
//
//     for await (const line of rl) {
//         input.push(line);
//         rl.close();
//     }
//
//     process.exit();
// })();

/**
 * [solution]
 * - 각 마을의 높이를 배열에 초기화 시킨다.
 * - M일동안 비가 내린다.
 * - 0 ~ M까지 반복문 돌면서, 위치에 해당하는 마을의 물 높이를 증가시켜준다.
 * - 현재 비가 내리는 날이 3의 배수라면, 배수 시스템이 작동한다.
 *  - 배수 시스템은 2일 이내에 내린 비만 배수된다.
 * - 장마가 지나간뒤 땅 높이는 쌓인 물 높이만큼 증가한다. => 즉, 기존 땅에서 물 높이를 더해준다.
 */
function solution(input) {
    const [N, M] = input[0].split(" ").map(Number);
    const villages = input[1].split(" ").map(Number);
    let waterHeight = Array(N).fill(0);

    const logs = new Set();

    // 장마 기간
    for (let i = 0; i < M; i++) {
        const [s, e] = input[i + 2].split(" ").map(Number);
        for (let j = s - 1; j < e; j++) {
            waterHeight[j]++;
            logs.add(j);
        }

        //배수 시스템 작동
        if ((i + 1) % 3 === 0) {
            for (const log of logs) {
                waterHeight[log] = Math.max(0, waterHeight[log] - 1);
            }
            logs.clear();
        }
    }

    for(let i = 0; i < villages.length; i++) {
        villages[i] += waterHeight[i];
    }
    return villages.join(" ");
}

const input = [
    "5 7",
    "0 0 0 0 0",
    "1 5",
    "1 5",
    "1 5",
    "1 5",
    "1 5",
    "1 5",
    "1 2",
];

console.log(solution(input));