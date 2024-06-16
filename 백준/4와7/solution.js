const input = [1];

function solution(K) {
    K = Number(K) + 1;

    let stringNumber = "";
    let number = 0;
    while(K !== 0) {
        number = K % 2;
        stringNumber += number;
        K = Math.floor(K / 2);
    }

    let answer = "";
    for(let i = stringNumber.length - 2; i >= 0 ; i--) {
        answer += stringNumber[i] === "0" ? "4" : "7";
    }

    return answer;
}

console.log(solution(6));