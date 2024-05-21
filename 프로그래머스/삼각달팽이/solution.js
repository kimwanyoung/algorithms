/**
 * [solution]
 * - 1 ~ n까지 총 합을 구한다.
 * - 크기가 1 ~ n인 배열을 각각 초기화 해준다.
 * - 왼쪽 부터 배열을 채워 나간다.
 * - 왼쪽이 다 찼다면 오른쪽으로 채워 나간다.
 * - 오른쪽으로도 다 채웠다면, 대각선 위로 채워 나간다.
 * - i가 n까지의 총 합보다 같을때까지 반복한다.
 */
const solution = (n) => {
    const sum = n * (n + 1) / 2;
    const arr = Array(n).fill([]).map((_, idx) => Array(idx + 1).fill(0));

    let [i, j, number] = [0, 0, 1];
    while(number <= sum) {
        while(i < n && !arr[i][j]) {
            arr[i++][j] = number++;
        }

        i--;
        j++;
        while(j < n && !arr[i][j]) {
            arr[i][j++] = number++;
        }

        i--;
        j -= 2;
        while(i > 0 && j > 0 && !arr[i][j]) {
            arr[i--][j--] = number++;
        }

        i += 2;
        j++;
    }

    return arr.flat();
}

console.log(solution(5));