function findFibonacciSum(n) {
    const fibonacci = [0, 1];
    let k = 2;
    while (fibonacci[k - 1] < n) {
      fibonacci[k] = fibonacci[k - 1] + fibonacci[k - 2];
      k++;
    }
    
    const result = [];
    let i = k - 1;
    while (n > 0 && i >= 0) {
      if (n >= fibonacci[i]) {
        result.push(fibonacci[i]);
        n -= fibonacci[i];
      }
      i--;
    }
    
    return result.reverse();
  }
  input.shift()
  const piboNum = input.map(Number)
  console.log(piboNum)
  for(let i = 0 ; i < piboNum.length; i++){
      console.log(findFibonacciSum(piboNum[i]).join(' '))
  }