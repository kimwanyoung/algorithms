const solution = (priorities, location) => {
  let answer = 0;
  let processQueue = priorities.map((process, index) => {
    return { process, index };
  });

  while (processQueue.length) {
    const queue = processQueue.shift();

    if (processQueue.some((element) => element.process > queue.process)) {
      processQueue.push(queue);
    } else {
      answer++;
      if (queue.index === location) break;
    }
  }

  return answer;
};
