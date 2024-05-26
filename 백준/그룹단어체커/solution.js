/**
 * [solution]
 * - 단어들을 split("")으로 자른다.
 * - 알파벳들을 순회하면서 객체에 알파벳을 키값으로 넣는다.
 * - 단어들을 키로 넣으면서 현재 들어간 단어를 prev에 저장한다.
 * - 만약 이미 존재하는 단어가 나왔다면, prev와 같은지 비교하고 다르다면, break;
 * -    조건에 만족하면 개수 ++;
 * - 총 개수 반환
 */

// const input = require("fs").readFileSync(0, "utf-8").split("\n");
const input = [
    "2",
    "yzyzy",
    "zyzyz",
]

const wordCount = Number(input[0]);
let answer = 0;
for(let i = 1; i <= wordCount; i++) {
    const words = input[i].split("");
    const wordDict = {};
    let prev = "";
    for(let j = 0; j < words.length; j++) {
        if(!wordDict[words[j]]) {
            wordDict[words[j]] = true;
            prev = words[j];
        } else {
            if(words[j] !== prev) {
                break;
            }
        }
        if(j === words.length - 1) answer++;
    }
}

console.log(answer);
