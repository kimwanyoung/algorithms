function solution(s) {
  let changeCount = 0;
  let deletedZeroCount = 0;

  while (s !== "1") {
    let deletedZero = s.split("0").join("");
    let length = s.length - deletedZero.length;
    s = deletedZero.length.toString(2);
    changeCount++;
    deletedZeroCount += length;
  }

  return [changeCount, deletedZeroCount];
}
solution("110010101001");
