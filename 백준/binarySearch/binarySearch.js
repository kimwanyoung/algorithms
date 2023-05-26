const binarySearch = (arr, target, start, end) => {
  while(start <= end){
    let mid = parseInt((start + end) / 2)
    if(arr[mid] === target) return mid
    else if (arr[mid] > target) end = mid  - 1
    else start = mid + 1
  }
}

const lowerBound = (arr, target, start, end) => {
  while(start <= end) {
    let mid = parseInt((start + end) / 2)
    if(arr[mid] >= target) end = mid
    else start = mid  + 1
  }
  return end
}

const upperBound = (arr, target, start, end) => {
  while(start <= end) {
    let mid = parseInt((start + end) / 2)
    if(arr[mid] > target) end = mid
    else start = mid  + 1
  }
  return end
}