const input = [2, 162]

const [s, t] = input;
const queue = [];
queue.push([s, 0]);

const visited = new Set();
let found = false;

while(queue.length !== 0) {
    const [value, dist] = queue.shift();

    if(value > 1e9) continue;
    if(value === t) {
        console.log(dist + 1);
        found = true;
        break;
    }

    for(const operator of ["*", "+"]) {
        let nextValue = value;
        if(operator === "*") nextValue *= 2;
        if(operator === "+") {
            nextValue *= 10;
            nextValue += 1;
        }
        if(!visited.has(nextValue)) {
            queue.push([nextValue, dist + 1]);
            visited.add(nextValue);

        }
    }
}

if(!found) console.log(-1);