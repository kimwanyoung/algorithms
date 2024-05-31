/**
 * [solution]
 * - R : 배열의 원소 뒤집기 Array.prototype.reverse()
 * - D : 배열의 첫번째 원소 버리기 Array.prototype.shift()
 *  - 빈 배열이면 error 출력
 * -> 시간 초과
 *
 * - R : isReverse상태를 변경한다.
 * - D : startIdx++, 만약, R이 true라면 endIdx--;
 * - 모든 결과를 outArr에 push해준다. startIdx가 endIdx보다 크면 원소가 없다는 것이므로 error push
 */

const [T, ...input] = [
    "4",
    "RDD",
    "4",
    "[1,2,3,4]",
    "DD",
    "1",
    "[42]",
    "RRD",
    "6",
    "[1,1,2,3,5,8]",
    "D",
    "0",
    "[]",
]

const output = [];

for(let i = 0; i < input.length; i+=3) {
    let n = Number(input[i + 1]);
    let arr = JSON.parse(input[i + 2]);

    let isReverse = false;
    let isError = false;
    let startIdx = 0;
    let endIdx = n - 1;

    for(const command of input[i]) {
        if(command === "R") {
            isReverse = !isReverse;
        } else {
            if(startIdx > endIdx) {
                isError = true;
                break;
            }

            if(isReverse) {
                endIdx--;
            } else {
                startIdx++;
            }
        }
    }

    const outputArr = arr.slice(startIdx, endIdx + 1);
    output.push(
        isError ? "error" : JSON.stringify(isReverse ? outputArr.reverse() : outputArr)
    );
}

console.log(output.join("\n"));