const minKey = (arr, char) => {
  let min = [];
  for (let i = 0; i < arr.length; i++) {
    min.push(arr[i].indexOf(char) + 1);
  }

  if (min.filter((num) => num === 0).length === arr.length) return -1;
  else return Math.min(...min.filter((num) => num !== 0));
};

const solution = (keymap, targets) => {
  let answer = Array(targets.length).fill(0);
  for (let i = 0; i < targets.length; i++) {
    let count = 0;
    for (let j = 0; j < targets[i].length; j++) {
      if (minKey(keymap, targets[i][j]) === -1) {
        answer[i] = -1;
        break;
      }
      answer[i] += minKey(keymap, targets[i][j]);
    }
  }

  return answer;
};
