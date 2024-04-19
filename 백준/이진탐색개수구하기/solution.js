const arr = [1,2,3,4,5,5,5,5,5,5,6,7,8];

const lowerBound = (arr, target, start, end) => {
    while(start < end) {
        let mid = parseInt((start + end) / 2);
        if(arr[mid] >= target) end = mid;
        else start = mid + 1;
    }
    return end;
}

const upperBound = (arr, target, start, end) => {
    while(start < end) {
        let mid = parseInt((start + end) / 2);
        if(arr[mid] > target) end = mid;
        else start = mid + 1;
    }
    return end;
}

console.log("lower bound : ", lowerBound(arr, 5, 0, arr.length));
console.log("upper bound : ", upperBound(arr, 5, 0, arr.length));
console.log("result : ", upperBound(arr, 5, 0, arr.length) - lowerBound(arr, 5, 0, arr.length));
