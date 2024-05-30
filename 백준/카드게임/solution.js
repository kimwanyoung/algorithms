/**
 * [solution]
 * <점수를 정하는 규칙>
 *
 * 카드 5장이 모두 같은 색이면서 숫자가 연속적일 때, 점수는 가장 높은 숫자에 900을 더한다. 예를 들어, 카드가 Y4, Y3, Y2, Y5, Y6 일 때 점수는 906(=6+900)점이다.
 * 카드 5장 중 4장의 숫자가 같을 때 점수는 같은 숫자에 800을 더한다. 예를 들어, 카드가 B3, R3, B7, Y3, G3 일 때 점수는 803(=3+800)점이다.
 * 카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때 점수는 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음 700을 더한다. 예를 들어, 카드가 R5, Y5, G7, B5, Y7 일 때 점수는 757(=5x10+7+700)점이다.
 * 5장의 카드 색깔이 모두 같을 때 점수는 가장 높은 숫자에 600을 더한다. 예를 들어, 카드가 Y3, Y4, Y8, Y6, Y7 일 때 점수는 608(=8+600)점이다.
 * 카드 5장의 숫자가 연속적일 때 점수는 가장 높은 숫자에 500을 더한다. 예를 들어 R7, R8, G9, Y6, B5 일 때 점수는 509(=9+500)점이다.
 * 카드 5장 중 3장의 숫자가 같을 때 점수는 같은 숫자에 400을 더한다. 예를 들어 R7, Y7, R2, G7, R5 일 때 점수는 407(=7+400)점이다.
 * 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 점수는 같은 숫자 중 큰 숫자에 10을 곱하고 같은 숫자 중 작은 숫자를 더한 다음 300을 더한다. 예를 들어, R5, Y5, Y4, G9, B4 일 때 점수는 354(=5X10+4+300)점이다.
 * 카드 5장 중 2장의 숫자가 같을 때 점수는 같은 숫자에 200을 더한다. 예를 들어, R5, Y2, B5, B3, G4 일 때 점수는 205(=5+200)점이다.
 * 위의 어떤 경우에도 해당하지 않을 때 점수는 가장 큰 숫자에 100을 더한다. 예를 들어, R1, R2, B4, B8, Y5 일 때 점수는 108(=8+100)점이다.
 * 입력으로 카드 5장이 주어질 때, 카드 게임의 점수를 구하는 프로그램을 작성하시오. 두 가지 이상의 규칙을 적용할 수 있는 경우에는 가장 높은 점수가 카드 게임의 점수이다.
 *
 * - 각 조건에 맞게 메서드 구현
 * - input으로 들어온 카드들을 색깔, 숫자로 나누어 각각 배열에 저장한다.
 * - 메서드에 각 배열을 넣고 점수 반환
 * - 가장 점수가 높은 규칙 순으로 메서드 적용
 * - 1. 카드 5장이 색이 같은 경우 + 숫자 연속
 * - 2. 카드의 4장의 숫자가 같은 경우
 * - 3. 카드의 3장의 숫자가 같은 경우 + 나머지 숫자도 같은 경우
 * - 4. 카드 5장의 색이 같은 경우
 * - 5. 카드 5장의 숫자가 연속적인 경우
 * - 6. 카드 3장의 숫자가 같은경우
 * - 7. 카드 2장의 숫자가 같은 경우 + 나머지 3장중 2장이 같은 경우
 * - 8. 카드 2장의 숫자가 같은 경우
 *
 */

// 같은 카드 개수 반환
function hasSame(arr) {
    const removeDup = Array.from(new Set(arr)).length;
    if(removeDup === 5) return 0;
    return 6 - removeDup;
}

// 5개의 숫자가 연속적인지 boolean 반환
function hasContinuousNumber(numbers) {
    numbers.sort();
    for(let i = 1; i < numbers.length; i++){
        if(numbers[i] - numbers[i - 1] !== 1) {
            return false;
        }
    }
    return true;
}

// 중복 숫자와, 개수 반환
function findDuplicateNumbers(numbers) {
    const obj = {};
    const results = [];

    for (let i = 0; i < numbers.length; i++) {
        if (obj[numbers[i]]) {
            results.push(numbers[i]);
        } else {
            obj[numbers[i]] = true;
        }
    }

    return Array.from(new Set(results));
}

function findDuplicateNumberCount(numbers) {
    const obj = {};

    for (let i = 0; i < numbers.length; i++) {
        if (obj[numbers[i]]) {
            obj[numbers[i]]++;
        } else {
            obj[numbers[i]] = 1;
        }
    }

    return obj;
}

function calculateScore(colors, numbers) {
    if(hasSame(colors) === 5 && hasContinuousNumber(numbers)) {
        return numbers.pop() + 900;
    }
    if(hasSame(numbers) === 4 && findDuplicateNumbers(numbers).length === 1) {
        const duplicates = findDuplicateNumbers(numbers);
        return duplicates[0] + 800;
    }
    if(hasSame(numbers) === 4 && findDuplicateNumbers(numbers).length === 2){
        let score = 0;
        const duplicates = findDuplicateNumberCount(numbers);
        for(const key in findDuplicateNumberCount(numbers)) {
            if(duplicates[key] === 3) {
                score += Number(key) * 10;
            }
            if(duplicates[key] === 2) {
                score += Number(key);
            }
        }
        return score + 700;
    }
    if(hasSame(colors) === 5) {
        numbers.sort();
        return numbers.pop() + 600;
    }
    if(hasContinuousNumber(numbers)){
        return numbers.pop() + 500;
    }
    if(hasSame(numbers) === 3 && findDuplicateNumbers(numbers).length === 1) {
        const duplicates = findDuplicateNumberCount(numbers);
        for(const key in duplicates) {
            if(duplicates[key] === 3) {
                return Number(key) + 400;
            }
        }
    }
    if(hasSame(numbers) === 3 && findDuplicateNumbers(numbers).length === 2) {
        const duplicates = findDuplicateNumbers(numbers);
        duplicates.sort();
        return (duplicates[1] * 10 + duplicates[0]) + 300;
    }
    if(hasSame(numbers) === 2 && findDuplicateNumbers(numbers).length === 1) {
        return findDuplicateNumbers(numbers)[0] + 200;
    } else {
        numbers.sort((a, b) => b - a);
        return numbers[0] + 100;
    }
}


// const input = require("fs").readFileSync(0, "utf-8").split("\n");
const input = [
    "B 1",
    "R 2",
    "Y 3",
    "Y 6",
    "G 8",
]

const colors = [];
const numbers = [];

for(let i = 0; i < input.length; i++) {
    const [color, number] = input[i].split(" ");
    colors.push(color);
    numbers.push(Number(number));
}

const answer = calculateScore(colors, numbers);
console.log(answer.toString().trim());

