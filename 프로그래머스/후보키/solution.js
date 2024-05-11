/*
* [["100","ryan","music","2"],
* ["200","apeach","math","2"],
* ["300","tube","computer","3"],
* ["400","con","computer","4"],
* ["500","muzi","music","3"],
* ["600","apeach","music","2"]]
* result = 2
*
* 유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
* 최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다.
                     즉, 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한 속성들로만 구성되어야 한다.

* [solution]
* - 우선 모든 후보키를 구한다.
* - 구해놓은 후보키 중에서 유일성을 만족하는 후보키를 구한다.
*   - 후보키 배열을 순회하면서, set을 사용하여 기존 배열과 Set의 크기가 같으면 유일성 만족
*  - 최소성을 만족하는 배열을 구한다.
*   - 앞에 유일성을 만족하는 배열이 존재하지 않는 배열만 구한다.
* */

const solution = (relations) => {
    let answer = 0;

    const relationIdxArr = Array.from({length: relations[0].length }, (_, i) => i);
    let combinations = [];

    relationIdxArr.forEach((idx) => {
        combinations.push(...combination(relationIdxArr, idx + 1));
    })


    combinations = checkUnique(relations, combinations);
    combinations = checkMinimality(combinations);

    return combinations.length;
}

const checkUnique = (relations, combinations) => {
    let results = [];

    combinations.forEach((combination) => {
        let set = new Set();
        relations.forEach((relation) => {
            set.add(combination.map((cb) => relation[cb]).join(","));
        })
        if(set.size === relations.length){
            results.push(combination)
        }
    })

    return results;
}

const checkMinimality = (combinations) => {
    let results=[];

    while(combinations.length){
        results.push(combinations[0]);
        combinations=combinations.reduce((acc,cur)=>{
            let notMinimal=combinations[0].every(combination=>cur.includes(combination));
            if(!notMinimal) acc.push(cur);
            return acc;
        }, [])
    }

    return results;
}

const combination = (arr, selectCount) => {
    let result = [];
    if (selectCount === 1) return arr.map(elem => [elem]);
    arr.forEach((fix, index, origin) => {
        const rest = origin.slice(index + 1);
        const cb = combination(rest, selectCount - 1);
        const attach = cb.map((c) => [fix, ...c]);
        result.push(...attach);
    })
    return result;
}
