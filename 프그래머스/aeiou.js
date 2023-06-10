function solution(word) {
  let idx = 0;
  const result = {};
  const vowels = [..."AEIOU"];

  const dfs = (word, length) => {
    if (length > 5) return;
    result[word] = idx++;
    vowels.forEach((vowel) => {
      dfs(word + vowel, length + 1);
    });
  };

  dfs("", 0);
  return result[word];
}
