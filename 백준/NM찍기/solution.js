const input = ["10", "11"];

function solution(input) {
    const [N, M] = input;

    let number = 1;
    let answer = "";
    for(let i = 0; i < Number(N); i++) {
        for(let j = 0; j < Number(M); j++) {
            if(j === M - 1) answer += number + "\n";
            else answer += number + " ";
            number++;
        }
    }

    console.log(answer);
}

solution(input);