/**
 * 3 7 13 17
 * 15 7 25 17
 * 5 2 15 12
 * [solution]
 * - 모든 색종이의 넓이에서 겹쳐진 부분을 빼준다.
 * - 겹쳐진 부분은... 모든 겹쳐진 부분 찾기 힘들 것 같다.
 *
 * - 100 * 100 고정이기 때문에 미리 배열 선언 후 색종이가 있는 부분만 채워서 반환
 */

const input = [
    "3",
    "3 7",
    "15 7",
    "5 2",
]

const colorPaperCount = Number(input[0]);
const paper = Array.from(Array(100), () => Array(100).fill(0));
let count = 0;

for(let i = 1 ; i <= colorPaperCount; i++) {
    const [x, y] = input[i].split(" ").map(Number);
    for(let j = 0; j < 10; j++) {
        for(let k = 0; k < 10; k++) {
            if(!paper[x + j][y + k]) {
                paper[x + j][y + k] = 1;
                count++;
            }
        }
    }
}

console.log(count);