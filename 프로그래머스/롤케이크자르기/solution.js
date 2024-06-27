function solution(topping) {
    let answer = 0;

    const left = {};
    const right = topping.reduce((acc, v) => {
        acc[v] = (acc[v] ?? 0) + 1;
        return acc;
    }, {});

    let leftCount = 0;
    let rightCount = new Set(topping).size;

    for(let i = 0 ; i < topping.length; i++) {
        const currentTopping = topping[i];
        if(!left[currentTopping]) {
            leftCount++;

        }
        left[currentTopping] = (left[currentTopping] ?? 0) + 1;

        right[currentTopping]--;
        if(!right[currentTopping]) {
            rightCount--;
        }

        if(leftCount === rightCount) {
            answer++;
        }
    }

    return answer;
}