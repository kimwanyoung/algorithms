const solution = (users, emoticons) => {
    const answer = [];
    const permutation = getPermutation([10, 20, 30, 40], emoticons.length);

    permutation.forEach((combi) => {
        let service = 0; // 이모티콘 플러스 서비스 가입자
        const costs = Array(users.length).fill(0);

        combi.forEach((c, ci) => {
            users.forEach((user, ui) => {
                if (user[0] <= c)
                    costs[ui] += emoticons[ci] * ((100 - c) / 100);
            });
        });

        let sum = 0;
        for (let i = 0; i < costs.length; i++) {
            if (costs[i] < users[i][1]) {
                sum += costs[i];
            } else {
                service++;
            }
        }
        answer.push([service, sum]); // 정답배열에 추가
    });

    // 이모티콘 플러스 서비스 가입자 순으로 내림차순
    // 가입자가 같을 경우 이모티콘에 사용한 비용 순으로 내림차순
    // 가장 맨 앞에 있는게 최대값
    return answer.sort((a, b) => {
        if (a[0] > b[0]) return b[0] - a[0];
        else if (a[0] === b[0]) return b[1] - a[1];
    })[0];
}

const getPermutation = (arr, selectNum) => {
    // 중복 순열 구하기
    const result = [];

    if (selectNum === 1) return arr.map((v) => [v]);

    arr.forEach((v, idx, arr) => {
        const fixed = v;
        const restArr = arr;
        const permutationArr = getPermutation(restArr, selectNum - 1);
        const combineFix = permutationArr.map((v) => [fixed, ...v]);
        result.push(...combineFix);
    });

    return result;
}

console.log(solution([[40, 10000], [25, 10000]], [7000, 9000]))