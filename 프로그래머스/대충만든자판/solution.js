/**
 * [solution]
 * - keymap을 맵 형태로 선언 후 idx + 1로 초기화한다.
 *  - 모든 키맵을 순회하며 중복되어있으면 더 작은 수를 넣는다.
 * - target을 순회하면서, 현재 눌러야할 키값을 맵에서 찾은 후 더해준다.
 * - 최종 키 맵을 누른 횟수를 배열에 담아서 반환한다.
 */

const solution = (keymap, targets) => {
    const keysMap = {};

    keymap.forEach((keys) => {
        const eachKey = keys.split("");
        eachKey.forEach((key, idx) => {
            if(keysMap[key]) {
                keysMap[key] = Math.min(keysMap[key], idx + 1);
            } else {
                keysMap[key] = idx + 1;
            }
        })
    })

    const answer = [];
    targets.forEach((target) => {
        let count = 0;
        const eachTarget = target.split("");
        eachTarget.forEach((t) => {
            count += keysMap[t];
        })
        if(!count) {
            answer.push(-1);
        } else {
            answer.push(count);
        }
    })

    return answer;
}

console.log(solution(["ABACD", "BCEFD"],["ABCD","AABB"]));