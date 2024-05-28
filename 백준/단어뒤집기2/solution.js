/**
 * [solution]
 * - 문자열의 시작이 "<"이면, ">"가 나올 때까지 문자열에 그대로 더해준다.
 * - 일반 문자열이라면 스택에 담는다.
 * - 그 후 pop()을 통해 뒤에서 부터 꺼낸다.
 * - 뒤집어진 문자열을 기존 문자열에 더해준다.
 * - 위 과정 반복
 */


const input = "<ab cd>fe hg<ij kl>"

let answer = "";
let i = 0;
while(i < input.length) {
    const stack = [];
    if(input[i] === "<") {
        while(input[i] !== ">") {
            answer += input[i];
            i++;
        }

        if(input[i] === ">") {
            answer += input[i];
            i++;
        }
    } else {
        while(input[i] !== "<" && i < input.length) {
            if(input[i] === " ") {
                while(stack.length !== 0) {
                    const char = stack.pop();
                    answer += char;
                }
                answer += " ";
                i++;
            } else {
                stack.push(input[i]);
                i++;
            }
        }

        while(stack.length !== 0) {
            const char = stack.pop();
            answer += char;
        }
    }
}

console.log(answer);