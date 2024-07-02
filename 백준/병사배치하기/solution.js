const input = [
    "7",
    "15 11 4 8 5 2 4",
]

const numberOfSoldiers = Number(input[0]);
const soldiers = input[1].split(" ").map(Number);

soldiers.reverse();

const dp = new Array(numberOfSoldiers).fill(1);

for(let i = 0 ; i < numberOfSoldiers; i++) {
    for(let j = 0; j < i; j++) {
        if(soldiers[j] < soldiers[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
}

console.log(numberOfSoldiers - Math.max(...dp));