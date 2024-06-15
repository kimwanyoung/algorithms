/**
 - 계획한 문제를 푸는데 필요한 최소 시간을 구해야하기 때문에 시간 기준으로 오름차순 정렬한다.
 - 난이도 별로 필요한 개수에 맞게 새로운 배열(problems)에 2차원 배열로 저장한다.
 - problems의 row의 각 원소를 하나씩 더하며, 이전 문제 푸는 시간을 변수에 저장해놓는다.
 - 다음 원소를 더할 때, 저장해 놓은 원소를 뺀 값도 같이 더해준다.
 - row의 모든 원소를 순회하였다면, column을 이동하며 60을 더해준다.
 - 모든 원소를 순회할 때까지 위 과정 반복
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

    const [problemCount, haveToSolving, ...problems] = input;
    solution(problemCount, haveToSolving, problems);
    process.exit();
})();

function solution(problemCount, haveToSolving, problems) {
    // 문제 풀이 난이도와 시간 기준으로 오름차순 정렬
    const sortedProblems = problems.map((problem) => problem.split(" ").map(Number)).sort((a, b) => {
        if(a[0] === b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });

    //난이도별 문제를 저장할 맵 초기화
    const solvingMap = {
        1: [],
        2: [],
        3: [],
        4: [],
        5: [],
    }

    haveToSolving = haveToSolving.split(" ").map(Number);
    // 난이도에 맞는 문제들 저장
    for(let i = 0; i < sortedProblems.length; i++) {
        const [level, time] = sortedProblems[i].map(Number);
        solvingMap[level].push([level, time]);
    }

    // 시간계산
    let totalTime = 0;
    for(const [levelKey, levelTimes] of Object.entries(solvingMap)) {
        let prevSolvingTime = levelTimes[0][1];
        for(let i = 0; i < haveToSolving[levelKey - 1]; i++) {
            const currentSolvingTime = levelTimes[i][1];
            totalTime += currentSolvingTime;
            //현재 걸린 시간에서 이전에 걸린시간의 차 만큼 휴식시간이기 때문에 휴식시간도 더해준다.
            totalTime += currentSolvingTime - prevSolvingTime;
            // 이전 문제 걸린시간 업데이트
            prevSolvingTime = currentSolvingTime;
        }
        // 레벨 이동으로 60분 더해준다. 레벨5가 최대 레벨이기 때문에 아닐때만 더해준다.
        if(Number(levelKey) !== 5) totalTime += 60;
    }

    console.log(totalTime);
}
