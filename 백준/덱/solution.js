// const input = require("fs").readFileSync(0, "utf-8").split("\n");

/**
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

const input = [
    "15",
    "push_back 1",
    "push_front 2",
    "front",
    "back",
    "size",
    "empty",
    "pop_front",
    "pop_back",
    "pop_front",
    "size",
    "empty",
    "pop_back",
    "push_front 3",
    "empty",
    "front",
]

const commandCount = Number(input[0]);
const deque = [];
let answer = "";

for(let i = 1; i <= commandCount; i++) {
    if(input[i] === "size") answer += size(deque) + "\n";
    else if(input[i] === "empty") answer += empty(deque) + "\n";
    else if(input[i] === "front") answer += front(deque) + "\n";
    else if(input[i] === "back") answer += back(deque) + "\n";
    else {
        const [command, number] = input[i].split(" ");
        if(command === "push_front") pushFront(deque, Number(number));
        if(command === "push_back") pushBack(deque, Number(number));
        if(command === "pop_front") answer += popFront(deque) + "\n";
        if(command === "pop_back") answer += popBack(deque) + "\n";
    }
}

console.log(answer);

function pushBack(deque, number) {
    deque.push(number);
}

function pushFront(deque, number) {
    deque.unshift(number);
}

function popFront(deque) {
    if(!deque.length) {
        return -1;
    }
    return deque.shift();
}

function popBack(deque) {
    if(!deque.length) {
        return -1;
    }
    return deque.pop();
}

function size(deque) {
    return deque.length;
}

function empty(deque) {
    return deque.length ? 0 : 1;
}

function front(deque) {
    return deque.length === 0 ? -1 : deque[0];
}

function back(deque) {
    return deque.length === 0 ? -1 : deque[deque.length - 1];
}
