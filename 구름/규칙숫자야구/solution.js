/**
 * [solution]
 * - 정답과 초기 입력을 배열에 초기화 시킨다.
 * - 배열 비교 함수를 만든다.
 * - 두 배열이 같아질 때 까지 반복문을 수행한다.
 * - 두 배열의 현재 숫자야구 상태 판단 함수 구현
 *  - 같은 숫자, 같은 자리 => strike
 *  - 배열에 숫자 포함, 다른 자리 => ball
 *  - 존재하지 않음 => fail
 * - 왼쪽부터 스트라이크를 판별하며, 다음 순서를 따른다.
 *  - 1. strike면 해당 위치를 표시하고 다음 숫자 비교를 시작한다.
 *  - 2. 현재 숫자가 fail이면 1을 더한 후 10으로 나눈 나머지를 대입해준다.
 *  - 3. ball이면 strike인 자리를 제외하고 인덱스를 하나씩 올린다. 마지막 인덱스일 경우, strike자리가 아닌 가장 앞 인덱스로 설정
 *      - 먼저 현재 배열 전체를 돌리고, 저장해 놨던 strike의 값을 다시 넣어준다.
 *      - 기존 값은
 */

Array.prototype.equals = function (otherArray) {
    if(this.length !== otherArray.length) return false;

    for(let i = 0; i < this.length; i++) {
        if(this[i] !== otherArray[i]) return false;
    }

    return true;
}

function solution(answer, inputNumbers) {
    let count = 1;
    while(!answer.equals(inputNumbers)) {
        const baseballStatus = [];
        for(let i = 0; i < 4; i++) {
            if(inputNumbers[i] === answer[i]) {
                baseballStatus.push("strike");
            } else if(answer.includes(inputNumbers[i])) {
                baseballStatus.push("ball");
            } else {
                baseballStatus.push("fail");
            }
        }
        for(let i = 0 ; i < baseballStatus.length; i++) {
            if(baseballStatus[i] === "strike") continue;
            if(baseballStatus[i] === "fail") {
                let number = (inputNumbers[i] + 1) % 10;
                while(inputNumbers.includes(number)) {
                    number = (number + 1) % 10;
                }
                inputNumbers[i] = number;
            }
        }

        if(baseballStatus.includes("ball")) {
            const move = [];
            for(let i = 0; i < baseballStatus.length; i++) {
                if(baseballStatus[i] !== "strike") {
                    move.push(inputNumbers[i]);
                }
            }
            move.unshift(move.pop());

            for(let i = 0, j = 0; i < baseballStatus.length; i++) {
                if(baseballStatus[i] !== "strike") {
                    inputNumbers[i] = move[j++];
                }
            }
        }

        count++;
    }

    console.log(count);
}

solution([1,2,3,4], [0,1,2,3]);