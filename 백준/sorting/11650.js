const input = ["5", "3 4", "1 1", "1 -1", "2 2", "3 3"];
const count = Number(input[0]);

const graph = [];
for (let i = 1; i <= count; i++) {
  graph.push(input[i].split(" ").map(Number));
}

graph.sort((a, b) => {
  if (a[0] === b[0]) return a[1] - b[1];
  return a[0] - b[0];
});

let answer = "";
for (let i = 0; i < graph.length; i++) answer += graph[i].join(" ") + "\n";
console.log(answer);
