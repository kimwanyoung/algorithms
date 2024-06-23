const input = [
    "6",
    "5",
    "2 3",
    "3 4",
    "4 5",
    "5 6",
    "2 5",
]

const n = Number(input[0]);
const m = Number(input[1]);
const friends = Array.from(Array(n + 1), () => []);

for(let i = 2; i <= m + 1; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    friends[a].push(b);
    friends[b].push(a);
}

function solution(n, m, friends) {
    let total = 0;
    const visited = new Set([1]);
    const queue = [];
    queue.push([1, 0]);

    while(queue.length !== 0) {
        const [current, distance] = queue.shift();

        for(const next of friends[current]) {
            if(distance + 1 > 2) continue;
            if(!visited.has(next)) {
                queue.push([next, distance + 1]);
                visited.add(next);
                total++;
            }
        }
    }

    console.log(total);
}

solution(n, m, friends);