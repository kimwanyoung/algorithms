/**
 * [solution]
 * - today에 주어지는 날짜를 "."으로 split()한다.
 * - Date.getTime()을 이용하여 시간으로 날짜를 변환한다.
 * - privacies를 순회하면서 해당 terms에 유효기간을 더한다.
 *  - 더한 후 getTime을 이용한 값이 현재 오늘 날짜 보다 작거나 같다면, answer배열에 현재 인데스 + 1을 넣어준다.
 * - answer 반환
 */
const solution = (today, terms, privacies) => {
    const answer = [];
    const [todayYear, todayMonth, todayDate] = today.split(".").map(Number);
    const todayTime = new Date(todayYear, todayMonth, todayDate).getTime();
    const expirationPeriods = {};

    terms.forEach((term) => {
        const [name, expirationPeriod] = term.split(" ");
        expirationPeriods[name] = Number(expirationPeriod);
    })

    privacies.forEach((privacy, idx) => {
        const [startDate, name] = privacy.split(" ");
        const [year, month, date] = startDate.split(".").map(Number);
        const expirationTime = new Date(year, month + expirationPeriods[name], date).getTime();

        if(expirationTime <= todayTime) {
            answer.push(idx + 1);
        }
    })

    return answer;
}
