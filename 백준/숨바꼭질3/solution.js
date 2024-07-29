const input = ["5 7"];
const [n, k] = input[0].split(" ").map(Number);
const MAX = 100001;

console.log(bfs());

function bfs() {
    const q = [[n, 0]];
    const visited = Array(MAX).fill(false);
    visited[n] = 0;

    while(q.length !== 0) {
        const [current, time] = q.shift();

        if(current === k) return time;
        for(const next of [current - 1, current + 1, current * 2]) {
            if(next < 0 || next >= MAX || visited[next]) continue;
            if(next === current * 2) {
                q.unshift([next, time]);
            } else {
                q.push([next, time + 1]);
            }
            visited[next] = true;
        }
    }
}