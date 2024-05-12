/**
 * [solution]
 * - 모든 성격 유형을 원소를 갖는 객체를 생성한다.
 * - 모든 답변의 점수는 4 - 항목 번호이다. ex) 1 : 4 - 1 = 3점
 * - survey를 순회하면서, 왼쪽의 항목에 대한 점수를 미리 선언한 성격 유형 객체에 더해준다.
 * - ["TR", "FC", "MJ", "NA"] 이 4가지 유형을 순회하면서, 문자를 두 유형으로 쪼개고 점수가 높은 순으로 answer에 더해준다
 *  - 점수가 같다면, 사전순으로 더 앞에 있는 유형을 더해준다.
 */

const solution = (survey, choices) => {
    let answer = "";
    const category = ["TR", "FC", "MJ", "NA"];
    const personality = {
        R: 0,
        T: 0,
        F: 0,
        C: 0,
        M: 0,
        J: 0,
        A: 0,
        N: 0,
    }
    for(let i = 0; i < survey.length; i++) {
        const [p, _] = survey[i].split("");
        personality[p] += 4 - choices[i];
    }

    category.forEach((c) => {
        const [l, r] = c.split("");
        answer += personality[l] > personality[r] ? l : r;
    })

    return answer;
}
