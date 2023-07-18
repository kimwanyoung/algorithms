let input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [treeCount, height] = input[0].split(" ").map(Number);
const trees = input[1].split(" ").map(Number);

let start = 1;
let end = Math.max(...trees);

let result = 0;
while (start <= end) {
  const mid = parseInt((start + end) / 2);
  let totalCut = 0;
  for (let tree of trees) {
    if (tree > mid) totalCut += tree - mid;
  }

  if (totalCut < height) {
    end = mid - 1;
  } else {
    start = mid + 1;
    result = mid;
  }
}

console.log(result);
