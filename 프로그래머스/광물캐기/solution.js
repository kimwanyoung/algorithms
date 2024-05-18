/**
 * [solution]
 * - 현재 곡괭이 수량을 객체로 선언, 초기화한다.
 * - 각 곡괭이별 피로도를 객체로 선언, 초기화한다.
 * - minerals를 순회하면서, 가장 맨 앞의 index의 광석 곡괭이가 존재한다면, 해당 곡괭이의 개수를 -1
 *   하고 현재 곡괭이 상태를 업데이트한다. 그리고 해당 곡괭이로 캐는 광석의 피로도만큼 더해준다.
 * - 만약 해당 광물의 곡괭이가 존재하지 않는다면, 현재 곡괭이 = 곡괭이 배열[인덱스 + 1]
 * => 실패
 *
 * - minerals에서 5개씩 자른 후 가장 피로도가 높은 순으로 정렬한 뒤 최소 값 계산.
 */

const count = (ary,word) => ary.filter(el => el === word).length

function solution(picks, minerals) {
    let ret = 0
    const m = [];

    minerals = minerals.slice(0,picks.reduce((a,c) => a+5*c,0))
    const fatigue = [{'diamond' : 1 , 'iron' : 1 , 'stone' : 1},
        {'diamond' : 5 , 'iron' : 1 , 'stone' : 1},
        {'diamond' : 25 , 'iron' : 5 , 'stone' : 1}]

    for (let i=0 ; i< minerals.length ; i+=5) m.push(minerals.slice(i,i+5))
    m.sort((a,b) => {
        const aDiaCnt = count(a,'diamond')
        const bDiaCnt = count(b,'diamond')
        if (aDiaCnt === bDiaCnt) {
            const aIronCnt = count(a,'iron')
            const bIronCnt = count(b,'iron')
            return bIronCnt - aIronCnt
        }
        return bDiaCnt-aDiaCnt
    })

    let i = picks[0] ? 0 : picks[1] ? 1 : 2

    for (const mine of m){
        ret += mine.reduce((a,c) => a+fatigue[i][c],0)
        if (--picks[i]<=0) i++
        if (picks.every(el => !el)) return ret

    }
    return ret;
}