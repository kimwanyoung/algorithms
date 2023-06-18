const solution = (k, score) => {
  let answer = [];
  let price = [];

  for (let i = 0; i < score.length; i++) {
    price.push(score[i]);
    price.sort((a, b) => b - a);

    if (price.length > k) answer.push(price[k - 1]);
    else answer.push(price[price.length - 1]);
  }

  return answer;
};
