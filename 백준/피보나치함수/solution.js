const input = [
    "2",
    "6",
    "22",
]

const testcase = Number(input[0]);

const d = new Array(41).fill(0);

d[0] = [1, 0];
d[1] = [0, 1];

for(let i = 2; i < 41; i++) {
    const [xz, xo] = d[i - 1];
    const [yz, yo] = d[i - 2];
    d[i] = [xz + yz, xo + yo];
}

for(let i = 1; i <= testcase; i++) {
    const [cz, co] = d[Number(input[i])];
    console.log(cz, co);
}