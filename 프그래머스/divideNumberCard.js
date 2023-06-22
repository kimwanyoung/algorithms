const fitConditionNumber = (currentArray, targetArray) => {
  for (let i = currentArray[0]; i >= 0; i--) {
    if (
      currentArray.every((curr) => curr % i === 0) &&
      !targetArray.some((curr) => curr % i === 0)
    )
      return i;
  }
  return 0;
};

const solution = (arrayA, arrayB) => {
  const sortedA = arrayA.sort((a, b) => a - b);
  const sortedB = arrayB.sort((a, b) => a - b);

  return Math.max(
    fitConditionNumber(sortedA, sortedB),
    fitConditionNumber(sortedB, sortedA)
  );
};
