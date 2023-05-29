function solution(today, terms, privacies) {
  const answer = [];
  const todayToArr = today.split(".").map(Number);
  const todayToTime = new Date(
    todayToArr[0],
    todayToArr[1],
    todayToArr[2]
  ).getTime();
  const term = {};
  for (let i = 0; i < terms.length; i++) {
    let cate = terms[i].split(" ")[0];
    let due = Number(terms[i].split(" ")[1]);

    term[cate] = due;
  }

  for (let i = 0; i < privacies.length; i++) {
    let startTime = privacies[i].split(" ")[0].split(".").map(Number);
    let cate = privacies[i].split(" ")[1];
    let expiration = new Date(
      startTime[0],
      startTime[1] + term[cate],
      startTime[2]
    ).getTime();
    if (todayToTime >= expiration) {
      answer.push(i + 1);
    }
  }
  return answer;
}
