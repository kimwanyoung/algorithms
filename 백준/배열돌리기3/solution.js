/**
 * [solution]
 * - 배열 상하반전 연산
 *  - arr.length / 2 까지 반복하면서 새로운 두 배열에 각각 arr[i], arr[length - i]를 추가해준다.
 *  - 두 배열을 합쳐서 반환
 * - 배열 좌우반전 연산
 *  - 배열 크기가 최대 100이기 때문에 reverse()메서드 사용해서 구현
 * - 배열 오른쪽 90도 회전
 *   * 1 6 2 9 8 4 → 4 9 7 1 7 1
     * 7 2 6 9 8 2 → 2 2 4 8 2 6
     * 1 8 3 4 2 9 → 9 3 6 3 6 2
     * 7 4 6 2 3 1 → 3 6 2 4 9 9
     * 9 2 3 6 1 5 → 1 1 3 2 8 8
     * 4 2 9 3 1 8 → 8 5 1 9 2 4
     *    <배열>       <연산 결과>
 *    (0,0) => (0, length - 1) (0, 1) => (1, length - 1)
 *    (1,0) => (0, length - 2) (2, 0) => (0, length - 3) (2, 1) => (1, length - 3)
 *    (1,1) => (1, length - 2)
 *    (4,2) => (2, length - 5)
 * - 규칙이 존재한다.
 *  - 각 (i, j) 을 뒤집어서 (j, i)를 만들고 length - 1에서 -i를 해준다.
 *
 * - 배열 왼쪽 90도 회전도 위와 동일
 * - 5, 6번은 4구간으로 배열을 나누고 회전했을 때의 순서대로 다시 배열을 넣어준다.
 */
function upDownInversion(arr) {
    const [n, m] = [arr.length, arr[0].length];
    const newArr = Array.from({length: n},() => Array.from({length: m}).fill(0));

    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            newArr[i][j] = arr[n - 1 - i][j];
        }
    }

    return newArr;
}

function leftRightInversion(arr) {
    const [n, m] = [arr.length, arr[0].length];
    const newArr = Array.from({length: n},() => Array.from({length: m}).fill(0));

    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            newArr[i][j] = arr[i][m - 1 - j];
        }
    }

    return newArr;
}

function rotateRight(arr) {
    const [n, m] = [arr.length, arr[0].length];
    const newArr = Array.from({length: m},() => Array.from({length: n}).fill(0));
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            newArr[j][n - 1 - i] = arr[i][j];
        }
    }

    return newArr;
}

function rotateLeft(arr) {
    const [n, m] = [arr.length, arr[0].length];
    const newArr = Array.from({length: m},() => Array.from({length: n}).fill(0));
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            newArr[m - 1 - j][i] = arr[i][j];
        }
    }

    return newArr;
}

function rotateBundle(arr) {
    const [n, m] = [Math.floor(arr.length / 2), Math.floor(arr[0].length / 2)];
    const first = Array.from({length: n},() => Array.from({length: m}).fill(0));
    const second = Array.from({length: n},() => Array.from({length: m}).fill(0));
    const third = Array.from({length: n},() => Array.from({length: m}).fill(0));
    const forth = Array.from({length: n},() => Array.from({length: m}).fill(0));

    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            first[i][j] = arr[i][j];
            second[i][j] = arr[i][j + m];
            third[i][j] = arr[i + n][j];
            forth[i][j] = arr[i + n][j + m];
        }
    }

    return [first, second, third, forth];
}

function rotateBundleRight(arr) {
    const [first, second, third, forth] = rotateBundle(arr);

    const newArr = [];
    const newArr2 = [];
    for(let i = 0; i < first.length; i++) {
        newArr.push(third[i].concat(first[i]));
        newArr2.push(forth[i].concat(second[i]));
    }

    return newArr.concat(newArr2);
}

function rotateBundleLeft(arr) {
    const [first, second, third, forth] = rotateBundle(arr);

    const newArr = [];
    const newArr2 = [];
    for(let i = 0; i < first.length; i++) {
        newArr.push(second[i].concat(forth[i]));
        newArr2.push(first[i].concat(third[i]));
    }

    return newArr.concat(newArr2);
}

function solution(input) {
    const [N, M, R] = input[0].split(" ").map(Number);
    let arr = [];

    for(let i = 1; i <= N; i++) {
        arr.push(input[i].split(" ").map(Number));
    }

    const commands = input[N + 1].split(" ").map(Number);
    for(const command of commands) {
        if(command === 1) {
            arr = upDownInversion(arr);
        }
        if(command === 2) {
            arr = leftRightInversion(arr);
        }
        if(command === 3) {
            arr = rotateRight(arr);
        }
        if(command === 4) {
            arr = rotateLeft(arr);
        }
        if(command === 5) {
            arr = rotateBundleRight(arr);
        }
        if(command === 6) {
            arr = rotateBundleLeft(arr);
        }
    }

    let answer = "";
    for(let i = 0; i < arr.length; i++) {
        for(let j = 0; j < arr[0].length; j++) {
            answer += arr[i][j] + " ";
        }
        answer += "\n";
    }
    return answer;
}

const input = require("fs").readFileSync(0, "utf-8").split("\n");
console.log(solution(input));