// const input = require('fs').readFileSync(0, 'utf-8').split('\n');
const input = [
    '13',
    'but',
    'i',
    'wont',
    'hesitate',
    'no',
    'more',
    'no',
    'more',
    'it',
    'cannot',
    'wait',
    'im',
    'yours'
]

const wordCount = Number(input[0]);
let wordArr = new Set();

for (let i = 1; i <= wordCount; i++) {
    wordArr.add(input[i]);
}

wordArr = [...wordArr];
wordArr.sort((a, b) => {
    if(a.length === b.length) {
        if(a > b) return 1;
        else if(a < b) return -1;
        else return 0;
    }
    return a.length - b.length;
})

let answer = '';
for(const word of wordArr) {
    answer += word + '\n';
}
console.log(answer);
