const binaryArr = (n, arr) => {
  let binarys = [];
  for (let i = 0; i < arr.length; i++) {
    binarys.push(arr[i].toString(2).split("").join(""));
  }
  for (let i = 0; i < binarys.length; i++) {
    if (binarys[i].length < n) {
      let zeros = new Array(n - binarys[i].length).fill("0");
      binarys[i] = [...zeros, ...binarys[i]].join("");
    }
  }
  return binarys;
};

const secretMap = (str1, str2) => {
  const result = [];
  for (let i = 0; i < str1.length; i++) {
    if (str1[i] + str2[i] > 0) {
      result.push("#");
    } else {
      result.push(" ");
    }
  }
  return result.join("");
};

function solution(n, arr1, arr2) {
  var answer = [];
  const binary1 = binaryArr(n, arr1);
  const binary2 = binaryArr(n, arr2);

  for (let i = 0; i < n; i++) {
    answer.push(secretMap(binary1[i], binary2[i]));
  }
  return answer;
}
