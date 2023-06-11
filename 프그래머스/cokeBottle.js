const solution = (a, b, n) => {
  let answer = 0;
  let remain = 0;

  const cokeBottle = (n) => {
    if (n < a) return;
    answer += parseInt(n / a) * b;
    remain = n % a;
    return cokeBottle(parseInt(n / a) * b + remain);
  };

  cokeBottle(n);
  return answer;
};
