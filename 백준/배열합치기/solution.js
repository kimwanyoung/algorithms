/**
 * [solution]
 * - 두 배열 A, B 를 정렬한 하나의 배열로 출력하기
 * - 1. 단순히 A뒤에 B를 추가해서 정렬후 출력? => 성공, 하지만 더 효율적인 방법을 찾는다.
 * - 2. 포인터 두 개를 두고 미리 정렬 해 놓은 A, B의 0번부터 하나씩 확인해가며 새로운 배열에 push
 */

const input = [
    "2 2",
    "3 5",
    "2 9",
]

const [lengthA, lengthB] = input[0].split(" ").map(Number);
const A = input[1].split(" ").map(Number);
const B = input[2].split(" ").map(Number);
//
// A.push(...B);
// A.sort((a, b) => a - b);
// console.log(A.join(" "));

A.sort((a, b) => a - b);
B.sort((a, b) => a - b);

let pointerA = 0;
let pointerB = 0;
let currentMax = 0;
const arr = [];
while(pointerA < lengthA && pointerB < lengthB) {
    if(A[pointerA] <= B[pointerB]) {
        currentMax = A[pointerA];
        arr.push(A[pointerA]);
        pointerA++;
    } else {
        currentMax = B[pointerB];
        arr.push(B[pointerB]);
        pointerB++;
    }
}

if(pointerA < lengthA) arr.push(...A.slice(pointerA));
if(pointerB < lengthB) arr.push(...B.slice(pointerB));

console.log(arr.join(" "));