const lowerBound = (arr, target, start, end) => {
  while (start <= end) {
    let mid = parseInt((start + end) / 2);
    if (arr[mid] >= target) end = mid;
    else start = mid + 1;
  }
  return end;
};

const input = ["7", "15 11 4 8 5 2 4"];

const solider = Number(input[0]);
const soliderList = input[1].split(" ").map(Number);

soliderList.reverse();

const lis = [0];
for (let x of soliderList) {
  if (lis[lis.length - 1] < x) {
    lis.push(x);
  } else {
    let index = lowerBound(lis, x, 0, lis.length);
    lis[index] = x;
  }
}

console.log(solider - (lis.length - 1));
