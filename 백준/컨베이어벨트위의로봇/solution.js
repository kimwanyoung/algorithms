const fs = require('fs');

const getZeroCount = (arr) =>
    arr.reduce((acc, cur) => (cur === 0 ? acc + 1 : acc), 0);

const rotate = (arr, robots) => {
    const last = arr.pop();
    arr.unshift(last);

    robots.pop();
    robots.unshift(false);
};

const moveRobots = (arr, robots, N) => {
    for (let i = N - 2; i > -1; i--) {
        if (!robots[i]) continue;

        if (!robots[i + 1] && arr[i + 1] > 0) {
            robots[i + 1] = true;
            robots[i] = false;
            arr[i + 1] -= 1;
        }
    }
};

const addRobot = (arr, robots) => {
    if (arr[0] > 0) {
        arr[0] -= 1;
        robots[0] = true;
    }
};

const removeNthRobot = (robots, n) => {
    robots[n] = false;
};

const solution = (N, K, arr) => {
    const robots = new Array(N).fill(false);
    let stage = 0;

    while (getZeroCount(arr) < K) {
        stage++;
        rotate(arr, robots);
        if (robots[N - 1]) removeNthRobot(robots, N - 1);

        moveRobots(arr, robots, N);
        if (robots[N - 1]) removeNthRobot(robots, N - 1);

        addRobot(arr, robots);
    }

    return stage;
};

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, K] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

console.log(solution(N, K, arr));