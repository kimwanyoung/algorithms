const input = require('fs').readFileSync('/dev/stdin', 'utf8').split(' ').map(Number);
const [F, S, G, U, D] = input;
const [u, d] = [U, -D];
const visited = Array(F + 1).fill(false);

const queue = [[S, 0]]; // [current floor, steps]
visited[S] = true;

while(queue.length > 0) {
    const [currentFloor, steps] = queue.shift();
    if(currentFloor === G) {
        console.log(steps);
        return;
    }

    const nextFloors = [currentFloor + u, currentFloor + d];
    for(const next of nextFloors){
        if(next > 0 && next <= F && !visited[next]) {
            visited[next] = true;
            queue.push([next, steps + 1]);
        }
    }
}

console.log("use the stairs");