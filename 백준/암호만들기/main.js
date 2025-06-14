// const input = require('fs').readFileSync('/dev/stdin', 'utf8');
// const lines = input.trim().split('\n');

const lines = ["4 6", "a t c i s w"];

const [L, C] = lines[0].split(" ").map(Number);
const alphabets = lines[1].trim().split(" ").sort();
const vowels = ["a", "e", "i", "o", "u"];

generatePasswords(0, "");

function isValidPassword(password) {
  const vowelCount = password
    .split("")
    .filter((c) => vowels.includes(c)).length;
  return vowelCount >= 1 && password.length - vowelCount >= 2;
}

function generatePasswords(idx, password) {
  if (password.length === L) {
    if (isValidPassword(password)) {
      console.log(password);
    }
    return;
  }

  for (let i = idx; i < C; i++) {
    generatePasswords(i + 1, password + alphabets[i]);
  }
}
