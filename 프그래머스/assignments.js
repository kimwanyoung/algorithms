const timeToInt = (time) => {
  const [hour, minutes] = time.split(":").map(Number);
  return hour * 60 + minutes;
};

const solution = (plans) => {
  const assignments = plans.map((subject) => {
    const [name, start, playtime] = subject;
    return [name, timeToInt(start), Number(playtime)];
  });

  assignments.sort((current, next) => {
    const currentTime = current[1];
    const nextTime = next[1];
    return nextTime - currentTime;
  });

  let stack = [];
  while (assignments.length) {
    const [name, start, playtime] = assignments.pop();

    stack.forEach((subject, idx) => {
      if (start < subject[1]) stack[idx][1] += playtime;
    });

    stack.push([name, start + playtime]);
  }

  const answer = stack.sort((a, b) => a[1] - b[1]).map((subject) => subject[0]);
  return answer;
};
