function solution(id_list, report, k) {
  let reported = [...new Set(report)];
  let reportedCount = Array(id_list.length).fill(0);
  let mail = Array(id_list.length).fill(0);
  let overK = [];

  for (let r of reported) {
    const user = r.split(" ")[0];
    const reportedUser = r.split(" ")[1];
    let index = id_list.indexOf(reportedUser);
    reportedCount[index] += 1;

    if (reportedCount[index] >= k) {
      overK.push(id_list[index]);
    }
  }

  reported.map((r, index) => {
    let a = r.split(" ")[0];
    let b = r.split(" ")[1];

    if (overK.indexOf(b) >= 0) {
      let idx = id_list.indexOf(a);
      mail[idx] += 1;
    }
  });

  return mail;
}
