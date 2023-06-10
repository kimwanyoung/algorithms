const solution = (cards1, cards2, goal) => {
  let cardIndex1 = 0;
  let cardIndex2 = 0;
  for (let i = 0; i < goal.length; i++) {
    if (goal[i] === cards1[cardIndex1]) cardIndex1++;
    else if (goal[i] === cards2[cardIndex2]) cardIndex2++;
    else return "No";
  }

  return "Yes";
};
