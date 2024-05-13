/**
 * [solution]
 * - callings의 길이만큼 반복문을 실행한다.
 *  - callings에서 현재 호명된 선수와 그 선수의 앞 선수와 swap을 진행한다.
 * => 시간초과
 *
 * - players의 이름을 key, 인덱스를 value로 갖는 map을 선언한다.
 * - callings의 길이만큼 반복문을 실행한다.
 * - callings의 현재 호명된 선수의 value를 -1;
 * - findKeyByValue 메서드 생성 후 호명된 선수 앞 선수를 구한 후 +1;
 * - map을 순위로 정렬한 배열 반환.
 * => 시간초과
 * - 호명된 선수 앞 선수를 찾는 것이 너무 비효율적.
 * - players에서 인덱스로 찾는 방법으로 수정
 */

const solution = (players, callings) => {
    const playerRanking = {};

    players.forEach((player, idx) => {
        playerRanking[player] = idx;
    })

    for(let i = 0; i < callings.length; i++) {
        const calledPlayerRank = playerRanking[callings[i]];
        const calledPlayer = callings[i];
        const frontPlayer = players[calledPlayerRank - 1];
        playerRanking[calledPlayer] -= 1;
        playerRanking[frontPlayer] += 1;

        players[calledPlayerRank - 1] = callings[i];
        players[calledPlayerRank] = frontPlayer;
    }

    return players;
}

console.log(solution(["mumu", "soe", "poe", "kai", "mine"],	["kai", "kai", "mine", "mine"]));