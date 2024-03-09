 const friends = ["muzi", "ryan", "frodo", "neo"]
 const gifts =  ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]

function solution(friends, gifts) {
    const list = friends.map(el => Array.from({ length: friends.length }, () => 0));
    const score = Array.from({ length: friends.length }, () => 0);

    for (const gift of gifts) {
        const data = gift.split(' ');
        list[friends.indexOf(data[0])][friends.indexOf(data[1])]++;
    }

    const rank = friends.map((_, idx) =>
        list[idx].reduce((a, b) => a + b, 0) - list.map(el => el[idx]).reduce((a, b) => a + b, 0)
    );
    console.log(rank);
    for (let i = 0; i < friends.length; i++) {
        for (let j = 0; j < friends.length; j++) {
            if (i === j) {
                continue;
            }

            if (list[i][j] > list[j][i]) {
                score[i]++;
            }

            if (list[i][j] === list[j][i] || (list[i][j] === 0 && list[j][i] === 0)) {
                if (rank[i] > rank[j]) score[i]++;
            }
        }
    }

    return Math.max(...score);
}

console.log(solution(friends, gifts));

