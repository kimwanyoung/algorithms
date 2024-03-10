/*
    const bandage = [5, 1, 5]
    const health = 30
    const attacks = [[2, 10], [9, 15], [10, 5], [11, 5]]
    const result = 5
*/

const solution = (bandage, health, attacks) => {
    const maxHealth = health;
    const [totalTime, healthPerSecond, bonusHealth] = bandage;
    const totalLength = attacks[attacks.length - 1][0];
    let currentAttack = attacks.shift();
    let continuity = 0;
    for(let i = 0 ; i <= totalLength; i++) {
        const [attackTime, damage] = currentAttack;
        if(attackTime === i) {
            health -= damage;
            continuity = 0;
            currentAttack = attacks.shift();
            if(health <= 0) {
                break;
            }
            continue;
        }
        health = addHealth(health, healthPerSecond, maxHealth);
        continuity += 1;
        if(continuity === totalTime) {
            health = addHealth(health, bonusHealth, maxHealth);
            continuity = 0;
        }
    }
    return health <= 0 ? -1 : health;
}

const addHealth = (currentHealth, addNumber, maxHealth) => {
    let health = currentHealth;
    if(currentHealth + addNumber > maxHealth) {
        return maxHealth;
    }
    health += addNumber;
    return health;
}
