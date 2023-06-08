function solution(clothes) {
  let clothesObj = {};

  for (let i = 0; i < clothes.length; i++) {
    const [clo, type] = clothes[i];
    clothesObj[type] ? (clothesObj[type] += 1) : (clothesObj[type] = 1);
  }

  let result = 1;
  for (const [key, value] of Object.entries(clothesObj)) result *= value + 1;
  return result - 1;
}

solution([
  ["crow_mask", "face"],
  ["blue_sunglasses", "face"],
  ["smoky_makeup", "face"],
]);
