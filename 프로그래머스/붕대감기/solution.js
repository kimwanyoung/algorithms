/**
 * [solution]
 * - bandage = [기술 시전 시간, 1초당 회복량, 추가 회복량]
 * - health = 최대 체력
 * - attacks = [공격 시간, 피해량][]
 *
 * - 시간을 나타내는 변수 time을 선언하고 0으로 초기화.
 * - 연속 성공을 나타내는 continuity변수를 선언하고 0으로 초기화.
 * - attacks에서 shift()한 값을 현재 공격 상태로 초기화 한다.
 * - while() 반복문을 실행한다.
 *  - 현재 공격 상태의 시간이 time과 같다면 즉시 체력을 감소시킨다.
 *      - 체력이 0과 같거나 작으면, break;
 *      - 현재 공격상태는 다시 attacks에서 shift()해서 업데이트한다.
 *          - 만약, attacks.length === 0 break
 *      - continuity 0으로 업데이트.
 *  - 현재 캐릭터의 체력을 bandage에서 제시한 회복량만큼 회복시킨다.
 *      - 최대 회복량보다 커지면, health = maxHealth;
 *      - continuity++
 *  - 만약, 기술 시전시간과 연속 성공이 같다면 추가 회복량만큼 더 회복한다.
 *      - continuity = 0
 *  - time++
 */

const solution = (bandage, health, attacks) => {
    const [skillTime, healPerSecond, bonusHeal] = bandage;
    const maxHealth = health;
    let time = 0;
    let continuity = 0;
    let currentAttack = attacks.shift();

    while(true) {
        if(time === currentAttack[0]) {
            health -= currentAttack[1];
            continuity = 0;

            if(health <= 0) {
                health = -1;
                break;
            }

            if(attacks.length === 0) {
                break;
            }
            currentAttack = attacks.shift();
        } else {
            health += healPerSecond;
            continuity++;

            if(continuity === skillTime) {
                health += bonusHeal;
                continuity = 0;
            }

            if(health >= maxHealth) health = maxHealth;
        }
        time++;
    }
    return health;
}

console.log(solution([3, 2, 7], 20, [[1, 15], [5, 16], [8, 6]]));