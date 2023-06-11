const measure = (number) => {
  let i = 0;
  let cnt = 0;
  while (i <= Math.sqrt(number)) {
    if (number % i === 0) {
      cnt++;
      if (number / i !== i) cnt++;
    }
    i++;
  }
  return cnt;
};

function solution(number, limit, power) {
  let weapon = [];
  for (let i = 1; i <= number; i++) {
    const soldiersPower = getMeasure(i);
    if (soldiersPower > limit) weapon.push(power);
    else weapon.push(soldiersPower);
  }
  return weapon.reduce((a, b) => a + b, 0);
}
