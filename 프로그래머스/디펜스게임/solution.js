const solution = (n, k, enemy) => {
    let answer = 0;
    for(let i = 0; i < enemy.length; i++) {
        if(n - enemy[i] <= 0 && k === 0) {
            break;
        }

        if(n - enemy[i] >= 0) {
            n -= enemy[i];
        } else {
            k -= 1;
        }
        answer++;
    }

    return answer;
}

console.log(solution(	7, 3, [4, 2, 4, 5, 3, 3, 1]));