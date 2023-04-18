let fs = require('fs')
let input = fs.readFileSync('/dev/stdin').toString().split('\n')

const isPalindrome = (word) => {
  return word === word.split('').reverse().join('')
}

const testCases = Number(input[0]);

const findMistake = (word) => {
  if (isPalindrome(word)) return 0;

  const length = word.length;
  for (let i = 0; i < parseInt(length / 2); i++) {
    if (word[i] !== word[length - i - 1]) {
      if (isPalindrome(word.substring(0, i) + word.substring(i + 1, length))) return 1;
      if (isPalindrome(word.substring(0, length - i - 1) + word.substring(length - i, length))) return 1;
      break;
    }
  }

  return 2;
}


for (let tc = 1; tc <= testCases; tc++) {
  const word = input[tc];
  console.log(findMistake(word));
}