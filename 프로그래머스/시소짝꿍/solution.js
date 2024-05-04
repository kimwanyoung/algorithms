/**
 * 1. 비율을 나타내는 배열 초기화
 * 2. weights를 key - value 형태로 초기화
 * 3. weights 반복을 돌면서, 내부에서 무게와 비율을 곱한 값을 구한다.
 * 4. Map에 [내부에서 무게와 비율]키를 가진 값이 존재하면 answer++
 */
const solution = (weights) => {
    let answer = 0;
    const ratios = [1, 3 / 2, 2, 4 / 3];
    const weightsMap = {};

    weights.sort((a,b)=> b - a).forEach((w) => {
        ratios.forEach((i)=>{
            if(weightsMap[w * i] ){
                answer += weightsMap[w * i];
            }
        });
        if (!weightsMap[w]) weightsMap[w] = 1;
        else weightsMap[w]++;
    });
    return answer;
}

solution([100,180,360,100,270]);