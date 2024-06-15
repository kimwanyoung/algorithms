/**
 [solution]
 - N * N 2차원 배열을 초기화 한다.
 - 각 배열을 순회 하면서 상하좌우를 확인한다.
 - 상하좌우에 모두 물든 단풍나무 수만큼 sum++; => calculateAdjacencyTree();
 - 하루가 지난 후, 한번에 계산위해 before 배열에 위치와 주변 나우 개수 push
 - before.length만큼 반복문 돌며 park -= 인접 나무 개수로 업데이트 해준다. 0보다 작으면 0할당
 - day++
 */

// Run by Node.js
const readline = require('readline');

(async () => {
    let rl = readline.createInterface({ input: process.stdin });
    const input = [];

    for await (const line of rl) {
        input.push(line);
    }
    rl.close();

    let [N, ...park] = input;

    N = Number(N);
    park = park.map((p) => p.split(" ").map(Number));
    solution(N, park);
    process.exit();
})();

function solution(N, park) {
    let before = [];
    let day = 0;

    while(calculateZero(park) !== N * N) {
        for(let i = 0; i < N; i++) {
            for(let j = 0; j < N; j++) {
                const adjacencyTreeCount = calculateAdjacencyTree(park, i, j);

                before.push([i, j, adjacencyTreeCount]);
            }
        }

        for(let i = 0; i < before.length; i++) {
            const [r, c, count] = before[i];
            park[r][c] -= count;
            if(park[r][c] < 0) park[r][c] = 0;
        }

        before = [];
        day++;
    }

    console.log(day);
}

function calculateAdjacencyTree(park, r, c) {
    let count = 0;
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];

    for(let i = 0; i < dy.length; i++) {
        const y = r + dy[i];
        const x = c + dx[i];

        if(y < 0 || y > park.length - 1 || x < 0 || x > park.length - 1) continue;

        if(park[y][x] === 0) count++;
    }

    return count;
}

function calculateZero(park) {
    const flatedPark = park.flat();
    return flatedPark.reduce((cnt, element) => cnt + (element === 0), 0);
}
