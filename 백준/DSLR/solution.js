const input = [
    "3",
    "1234 3412",
    "1000 1",
    "1 16",
]

const commands = ["D", "S", "L", "R"];

const n = Number(input[0]);
for(let i = 1; i <= n; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    console.log(bfs(a, b, ""));
}

function bfs(a, b, command) {
    const q = [];
    const visited = new Array(10000).fill(false);
    q.push([a, command]);
    visited[a] = true;

    while(q.length) {
        const [curA, curCommand] = q.shift();
        if(curA === b) return curCommand;

        for(const c of commands) {
            const afterA = executeCommand(curA, c);
            if(!visited[afterA]){
                visited[afterA] = true;
                q.push([afterA, curCommand + c]);
            }
        }
    }
}

function executeCommand(number, command) {
    if(command === "D") {
        if(number * 2 > 9999) return (number * 2) % 10000;
        return number * 2;
    }
    if(command === "S") {
        if(number === 0) return 9999;
        return number - 1;
    }
    if(command === "L") {
        return ((number % 1000) * 10) + Math.floor(number / 1000)
    }
    if(command === "R") {
        return  (number % 10) * 1000 + Math.floor(number / 10);
    }
}
