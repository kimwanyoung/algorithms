/**
 * [solution]
 * - report의 중복을 제거한 log라는 배열을 선언한다.
 * - id_list의 길이만큼 0으로 초기화 된 배열을 두개 선언한다.
 *  - 하나는 reportedUsers, 다른 하나는 feedbackUsers
 * - log를 순회하면서 신고 받은 유저의 id_list인덱스를 구하고, reportedUsers의 해당 인덱스에 1을 더해준다.
 * - 다시 log를 순회하면서 신고 받은 유저가 reportedUsers에서 k보다 큰 값을 갖고있으면, 신고한 유저를 feedbackUsers에서 더해준다.
 * - feedbackUsers 반환.
 */

const solution = (id_list, report, k) => {
    const log = [...new Set(report)];
    const reportedResults = Array.from({length: id_list.length}).fill(0);
    const feedbackUsers = Array.from({length: id_list.length}).fill(0);

    log.forEach((report) => {
        const [_, reported] = report.split(" ");
        const reportedIdx = id_list.indexOf(reported);
        reportedResults[reportedIdx] += 1;
    })

    log.forEach((report) => {
        const [user, reportedUser] = report.split(" ");
        const reportedIdx = id_list.indexOf(reportedUser);
        const reportIdx = id_list.indexOf(user);
        if(reportedResults[reportedIdx] >= k) {
            feedbackUsers[reportIdx] += 1;
        }
    })
    return feedbackUsers;
}
