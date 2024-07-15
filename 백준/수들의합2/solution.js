/**
 * [solution]
 * start = 0, end = 0, sum = 0
 * arr[end]의 값을 sum에 더해준다.
 * 만약, sum이 x보다 작으면 end++;
 * sum === x라면 result++, sum -= arr[start], start++;
 */


const input = [
    "10 5",
    "1 2 3 4 2 5 3 1 1 2",
]

const [n, m] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

let result = 0;
let sum = 0;
for(let start = 0, end = 0; start < n; start++) {
    while(end < n && sum < m) {
        sum += arr[end];
        end++;

    }
    if(start !== end && sum === m) result++;
    sum -= arr[start];
}

console.log(result);