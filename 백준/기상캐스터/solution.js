// const input = require("fs").readFileSync(0, "utf-8").split("\n");

const input = [
    "6 8",
    ".c......",
    "........",
    ".ccc..c.",
    "....c...",
    "..c.cc..",
    "....c...",
]
const [N, M] = input.shift().split(" ").map(Number);
const cloudArr = [];

for (let i = 0; i < N; i++) {
    cloudArr.push([]);
}

for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
        cloudArr[i].push(-1);
    }
}

let cloudState = -1;
for (let i = 0; i < input.length; i++) {
    for (let j = 0; j < input[i].length; j++) {
        if (input[i][j] === "c") {
            cloudState = 0;
            cloudArr[i][j] = cloudState;
            cloudState++;
        } else if (input[i][j] === "." && cloudState > -1) {
            cloudArr[i][j] = cloudState;
            cloudState++;
        }
    }
    cloudState = -1;
}

let answer = "";
cloudArr.forEach((clouds) => {
    clouds.forEach((cloud) => {
        answer += cloud + " ";
    })
    answer += "\n";
})

console.log(answer);