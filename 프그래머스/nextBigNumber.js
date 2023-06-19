const binaryCount = (number) => {
  return number
    .toString(2)
    .split("")
    .filter((c) => c !== "0").length;
};

function solution(n) {
  let i = n + 1;
  let countN = binaryCount(n);
  while (true) {
    let countI = binaryCount(i);
    if (countN === countI) return i;
    i++;
  }
}
