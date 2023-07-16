const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const fibonacci = (number) => {
  const fibArray = [0, 1];

  let nextFib;
  while (true) {
    nextFib = fibArray[fibArray.length - 1] + fibArray[fibArray.length - 2];
    if (nextFib > number) break;
    fibArray.push(nextFib);
  }

  return fibArray;
};

const numberCount = Number(input[0]);
const fibNumberList = [];
for (let i = 1; i <= numberCount; i++) {
  fibNumberList.push(Number(input[i]));
}

for (let i = 0; i < fibNumberList.length; i++) {
  const fibonacciArray = fibonacci(fibNumberList[i]);
  let sum = 0;
  let fibString = [];
  for (let j = fibonacciArray.length - 1; j >= 0; j--) {
    if (sum >= fibNumberList[i]) {
      break;
    }
    if (sum + fibonacciArray[j] <= fibNumberList[i]) {
      sum += fibonacciArray[j];
      fibString.push(fibonacciArray[j]);
    }
  }
  fibString.reverse();
  console.log(fibString.join(" "));
}
