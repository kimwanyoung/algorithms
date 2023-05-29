function solution(dartResult) {
  let answer = [];
  let field = ["S", "D", "T"];

  for (let i = 0; i < dartResult.length; i++) {
    if (dartResult[i] == 0 && answer[answer.length - 1] === "1") {
      answer.pop();
      answer.push("10");
    } else if (field.indexOf(dartResult[i]) < 0) answer.push(dartResult[i]);
    else
      answer[answer.length - 1] =
        answer[answer.length - 1] ** (field.indexOf(dartResult[i]) + 1);
  }

  let cnt = 0;
  while (answer.includes("*") || answer.includes("#")) {
    if (answer[cnt] === "*") {
      answer[cnt - 1] = answer[cnt - 1] * 2;
      answer[cnt - 2] = answer[cnt - 2] * 2;
      answer = answer.slice(0, cnt).concat(answer.slice(cnt + 1));
    } else if (answer[cnt] === "#") {
      answer[cnt - 1] = answer[cnt - 1] * -1;
      answer = answer.slice(0, cnt).concat(answer.slice(cnt + 1));
    }

    cnt++;
  }
  return answer.reduce((a, b) => a + b, 0);
}

solution("1D2S#10S");
