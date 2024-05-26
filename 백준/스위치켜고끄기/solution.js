/**
 * [solution]
 * - 남학생인 경우, 받은 숫자의 배수인 스위치를 반대 상태로 만든다
 *  - i = 1부터 스위치 배열의 크기까지 증가시키면서 i % 받은 숫자 === 0 일경우 상태변경
 * - 여학생인 경우, 받은 숫자를 기준으로 좌우 대칭인경우 가장 많이 대칭이 될 시점에 있는 모든 스위치의 상태를 변경
 *  - start, end = 받은 숫자
 *  - 만약(받은 숫자 - i === 받은 숫자 + i)
 *      - start -= i, end += i;
 *  - start부터 end까지 모든 스위치 상태 변경
 *  - 20개씩 잘라서 스위치 상태 반환
 */

const input = require("fs").readFileSync(0, "utf-8").split("\n");
const changeSwitchState = (switchArr, idx) => {
    switchArr[idx] = switchArr[idx] ? 0 : 1;
}

const male = (switchArr, number) => {
    for(let i = 1; i < switchArr.length; i++){
        if(i % number === 0) changeSwitchState(switchArr, i);
    }
}

const female = (switchArr, number) => {
    let start = number;
    let end = number;
    let i = 1;
    while(start > 1 && end < switchArr.length - 1) {
        if(switchArr[number - i] === switchArr[number + i]){
            start -= i;
            end += i;
        } else {
            break;
        }
    }

    if(start === end) {
        changeSwitchState(switchArr, number);
    } else {
        for(let i = start; i <= end; i++) {
            changeSwitchState(switchArr, i);
        }
    }

}

const switchArr = input[1].split(" ").map(Number);
switchArr.unshift(-1);
const studentCount = Number(input[2]);

for(let i = 3; i < studentCount + 3; i++) {
    const [gender, number] = input[i].split(" ").map(Number);
    if(gender === 1) {
        male(switchArr, number);
    }
    if(gender === 2) {
        female(switchArr, number);
    }
}

let answer = "";
for(let i = 1; i < switchArr.length; i++) {
    if(i % 20 === 0) answer += switchArr[i] + "\n";
    else answer += switchArr[i] + " ";
}

console.log(answer);