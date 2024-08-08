const input = [
    "2",
    "5",
    "4 1 5 2 3",
    "5",
    "1 3 7 9 5",
    "5",
    "4 1 5 2 3",
    "5",
    "1 3 7 9 5"
]

const T = Number(input[0]);

let answer = "";
for(let i = 0; i < T * 4; i += 4) {
    const N = Number(input[i + 1]);
    const arr1 = input[i + 2].split(" ").map(Number);
    arr1.sort((a, b) => a - b);
    const M = Number(input[i + 3]);
    const arr2 = input[i + 4].split(" ").map(Number);

    for(let j = 0; j < M; j++) {
        if(binarySearch(arr1, arr2[j], 0, N) >= 0) answer += 1;
        else answer += 0;
        answer += "\n";
    }
}
console.log(answer);

function binarySearch(arr, element, start, end) {
    while(start <= end) {
        const mid = Math.floor((start + end) / 2);
        if(arr[mid] === element) return mid;
        else if(arr[mid] > element) end = mid - 1;
        else start = mid + 1;
    }
    return -1;
}