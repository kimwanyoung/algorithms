const solution = (want, number, discount) => {
  let answer = 0;
  let need = {};

  for (let i = 0; i < want.length; i++) {
    need[want[i]] = number[i];
  }

  for (let i = 0; i + 10 <= discount.length; i++) {
    let copyNeed = { ...need };
    for (let j = 0; j < i + 10; j++) {
      if (copyNeed[discount[i + j]]) {
        copyNeed[discount[i + j]] -= 1;
      } else break;
    }

    if (Object.values(copyNeed).reduce((a, b) => a + b, 0) === 0) answer++;
  }

  return answer;
};
