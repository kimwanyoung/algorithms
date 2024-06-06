/**
 * [solution]
 * - 1번를 기준으로 양쪽을 나눈다. (0번과 마지막 인덱스에는 물이 고일 수 없기 때문)
 * - 왼쪽의 최대값과, 오른쪽의 최대값을 구한다.
 * - 왼쪽의 최대값, 오른쪽의 최대값 중 더 작은 수가 물이 고일 수 있는 가장 큰 수
 * - 위에서 구한 더 작은수에서 현재 블록을 빼주면 고일 수 있는 물이 된다.
 * - 들어온 input을 순회하면서 각 인덱스 마다 위 과정을 수행해준다.
 */

function solution(input) {
    const [H, W] = input[0].split(" ").map(Number);

    let water = 0;
    const map = input[1].split(" ").map(Number);
    for(let i = 1; i < W - 1; i++) {
        const leftMax = Math.max(...map.slice(0, i));
        const rightMax = Math.max(...map.slice(i + 1));
        const maxWaterHeight = Math.min(leftMax, rightMax);

        if(map[i] < maxWaterHeight) water += maxWaterHeight - map[i];
    }
    return water;
}

// const input = require("fs").readFileSync(0, "utf-8").split("\n");
const input = [
    "4 8",
    "3 1 2 3 4 1 1 2",
]
console.log(solution(input));