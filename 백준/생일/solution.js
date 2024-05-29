const input = [
    "5",
    "Mickey 1 10 1991",
    "Alice 30 12 1990",
    "Tom 15 8 1993",
    "Jerry 18 9 1990",
    "Garfield 20 9 1990"
]

const peopleCount = Number(input[0]);

const peopleArr = [];
for(let i = 1; i < peopleCount + 1; i++) {
    peopleArr.push(input[i].split(" "));
}

peopleArr.sort((a, b) => {
    if(a[3] === b[3]) {
        if(a[2] === b[2]) {
            return Number(a[1]) - Number(b[1]);
        }
        return Number(a[2]) - Number(b[2]);
    }
    return Number(a[3]) - Number(b[3]);
})

console.log(peopleArr[peopleArr.length - 1][0]);
console.log(peopleArr[0][0]);