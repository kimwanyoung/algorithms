const input = "7 392";

function solution(input) {
    const [s, y] = input.split(" ").map(Number);

    if(s === y) {
        console.log(0);
        return;
    }

    const operator = ["*", "+", "-", "/"];
    const calculator = {
        "+" : (a, b) => a + b,
        "*" : (a, b) => a * b,
        "-" : (a, b) => a - b,
        "/" : (a, b) => a / b,
    }
    const visited = new Set([s]);
    const queue = [];
    queue.push([s, ""]);
    let found = false;
    while(queue.length !== 0) {
        const [qs, qop] = queue.shift();
        if(qs === y) {
            console.log(qop);
            found = true;
            break;
        }

        for(let i = 0; i < 4; i++) {
            const curOperator = operator[i];
            const curResult = calculator[curOperator](qs, qs);
            if(curResult > 10e9) continue;
            if(!visited.has(curResult)) {
                queue.push([curResult, qop + curOperator]);
                visited.add(curResult);
            }
        }

    }

    if(!found) console.log(-1);
}

solution(input);