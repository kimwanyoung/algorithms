/**
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10....
 * 1, 2, 4,11,12,14,21,22,24, 41....
 */
const solution = (n) => {
    let answer = "";
    let mod = ["4", "1", "2"];

    while(n > 0) {
        answer = mod[n % 3] + answer;
        n = Math.floor((n - 1) / 3);
    }

    return answer;
}
console.log(solution(10));