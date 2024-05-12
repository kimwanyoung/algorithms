/**
 * [solution]
 * - 0 ~ 9까지 영단어를 갖는 numbers 배열을 선언한다 numbers.
 * - s를 split() 메서드를 사용하여 모두 나눈다.
 * - 나눠진 s를 순회하면서 temp 변수에 하나씩 더해준다.
 *      - 만약, Number(temp)가 NaN이 아니라면 바로 answer에 더해준다
 *      - 만약, 현재 temp값이 numbers에 존재하면 해당 값의 인덱스를 answer에 더해준다.
 * - Number로 변환한 answer를 반환한다.
 *
 * [solution2]
 * - numbers 배열이 끝날 때 까지, s를 계속해서 정규표현식을 통해 변환시켜 준다.
 * - Number(s)로 변환하여 반환한다.
 */
const solution = (s) => {
    let answer = "";
    const numbers = [
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    ];

    s = s.split("");
    let temp = "";
    s.forEach((char) => {
        temp += char;
        if(numbers.includes(temp)) {
            answer += numbers.indexOf(temp);
            temp = "";
        }

        if(Number(char) || char === "0") {
            answer += char;
            temp = "";
        }
    })

    return Number(answer);
}

function solution(s) {
    const numbers = [
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    ];

    for(let i = 0; i < numbers.length; i++){
        let cur = new RegExp(numbers[i], "g");
        s = s.replace(cur, i);
    }

    return Number(s);
}

console.log(solution("oneone4seveneight"));