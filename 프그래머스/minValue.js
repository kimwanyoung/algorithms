function solution(A, B) {
  var answer = 0;
  const a = A.sort((a, b) => a - b);
  const b = B.sort((a, b) => a - b);

  for (let i = 0; i < a.length; i++) {
    answer += a[i] * b[b.length - i - 1];
  }

  return answer;
}

solution([1, 4, 2], [5, 4, 4]);
