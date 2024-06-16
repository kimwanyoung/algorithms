const input = [
    "2",
    "36 77 85",
    "40 55 69",
]

const N = Number(input[0]);
const triangle = [];

for(let i = 1; i < N + 1; i++) {
    triangle.push(input[i].split(" ").map(Number).sort((a, b) => a - b));
}

let answer = "";
for(let i = 0; i < N; i++) {
    const [a, b, c] = triangle[i];
    if(a ** 2 + b ** 2 === c ** 2) answer += `Scenario #${i + 1}:\nyes`;
    else answer += `Scenario #${i + 1}:\nno`;
    answer += "\n\n"
}

console.log(answer);
