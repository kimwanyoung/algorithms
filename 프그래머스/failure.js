function solution(N, stages) {
  let answer = [];
  let p = stages.length;
  let stage = Array(N + 2).fill(0);

  for (let i = 0; i < p; i++) {
    stage[stages[i]] += 1;
  }

  for (let i = 1; i <= stage.length - 1; i++) {
    if (i === N + 1) break;
    answer[i] = { stage: i, failure: stage[i] / p };
    p -= stage[i];
  }

  answer
    .sort((a, b) =>
      a.failure === b.failure ? a.stage - b.stage : b.failure - a.failure
    )
    .pop();
  return answer.map((props) => props.stage);
}
