/**
 * [solution]
 *      I	V	X	L	C	D	M
 *  값	1	5	10	50	100	500	1000
 *  IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900
 * - 정해진 값들을 객체에 초기화 시킨다.
 */

const romeNumber = {
    M: 1000,
    CM: 900,
    D: 500,
    CD: 400,
    C: 100,
    XC: 90,
    L: 50,
    XL: 40,
    X: 10,
    IX: 9,
    V: 5,
    IV: 4,
    I: 1,
}

function numberToString(number) {
    let string = "";
    while(number !== 0) {
        let quo = 0;
        for(const key in romeNumber) {
            if(number / romeNumber[key] >= 1) {
                quo = Math.floor(number / romeNumber[key]);
                if(quo !== 0) {
                    for(let i = 0; i < quo; i++) {
                        string += key;
                    }
                }
                number = number % romeNumber[key];
            }
        }
    }
    return string;
}

function stringToNumber(numberArr) {
    let number = 0;
    for(let i = 0; i < numberArr.length; i++) {
        let temp = numberArr[i];
        if(temp === "I" || temp === "X" || temp === "C" && i < numberArr.length - 1) {
            temp += numberArr[i + 1];
            if(romeNumber.hasOwnProperty(temp)) {
                number += romeNumber[temp];
                i++;
                continue;
            }
        }

        number += romeNumber[numberArr[i]];
    }
    return number;
}

function solution(input) {
    const first = input[0].split("");
    const second = input[1].split("");

    const sum = stringToNumber(first) + stringToNumber(second);

    console.log(sum);
    console.log(numberToString(sum));
}

const input = [
    "DLIII",
    "MCMXL",
]

solution(input);