const solution = (new_id) => {
  const answer = new_id
    .toLowerCase()
    .replace(/[^\w-_.]/g, "")
    .replace(/\.+/g, ".")
    .replace(/^\.|\.$/g, "")
    .replace(/^$/, "a")
    .slice(0, 15)
    .replace(/\.$/, "");
  return answer.length <= 2
    ? answer + answer[answer.length - 1].repeat(3 - answer.length)
    : answer;
};
