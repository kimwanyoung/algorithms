/**
 * [solution]
 * - 가로, 세로 배열 두 개를 선언해서 모든 수를 방향에 맞게 넣어준다.
 * - 각 배열을 정렬 후 원소들의 차이가 가장 큰 수를 구한다.
 * - 두 배열에서 구한 차이가 큰 수가 가장 큰 사각형의 가로 세로이므로 곱해서 반환
 */

// const input = require("fs").readFileSync(0, "utf-8").split("\n");
const input = [
    "100 30",
    "4",
    "0 25",
    "1 70",
    "0 15",
    "1 40",
]

let [width, height] = input[0].split(" ").map(Number);
const cutCount = Number(input[1]);

let widthArr = [width, 0];
let heightArr = [height, 0];

for (let i = 2; i < cutCount + 2; i++) {
    const [direction, position] = input[i].split(" ").map(Number);
    if (direction) {
        widthArr.push(position);
    } else {
        heightArr.push(position);
    }
}

widthArr.sort((a, b) => a - b);
heightArr.sort((a, b) => a - b);

let maxWidth = 0;
for (let i = 1; i < widthArr.length; i++) {
    maxWidth = Math.max(maxWidth, widthArr[i] - widthArr[i - 1]);
}

let maxHeight = 0;
for (let i = 1; i < heightArr.length; i++) {
    maxHeight = Math.max(maxHeight, heightArr[i] - heightArr[i - 1]);
}

if (cutCount === 0) {
    maxHeight = height;
    maxWidth = width;
}

console.log(maxHeight * maxWidth);