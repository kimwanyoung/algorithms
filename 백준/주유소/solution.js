const input = require('fs').readFileSync(0, 'utf-8').split('\n');

// const input = [
//     '4',
//     '3 3 4',
//     '1 1 1 1',
// ]

/**
 * 1. 현재 주유소 가격보다 싼 주유소가 나올 때까지 (거리 * 현재 주유소 가격)
 * 2. 싼 주유소가 등장하면 현재 주유소 가격 변경해주고 위 과정 반복
 */

const distance = input[1].split(' ').map(Number);
const gasStations = input[2].split(' ').map(Number);

let totalPrice = BigInt(0);
let current = gasStations[0];

for(let i = 0; i < gasStations.length - 1; i++) {
    if(gasStations[i] < current) {
        current = gasStations[i];
    }
    totalPrice += BigInt(current) * BigInt(distance[i]);
}

console.log(String(totalPrice));

