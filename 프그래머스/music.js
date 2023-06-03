const specialTochar = (string) => {
  return string
    .replace(/C#/g, "c")
    .replace(/D#/g, "d")
    .replace(/F#/g, "f")
    .replace(/G#/g, "g")
    .replace(/A#/g, "a");
};

function solution(m, musicinfos) {
  m = specialTochar(m);
  const result = {};
  let timeout = 0;
  let text = "";
  for (let music of musicinfos) {
    text = "";
    let time = 0;
    let [firstTime, sectime, title, context] = music.split(",");
    let [firstHour, firstMin] = firstTime.split(":");
    let [secHour, secMin] = sectime.split(":");
    timeout = (secHour - firstHour) * 60 + (secMin - firstMin);

    context = specialTochar(context);

    let words = context.split("");
    while (timeout >= time) {
      for (let word of words) {
        if (time > timeout) break;
        text += word;
        time++;

        if (m.length <= text.length) {
          let textIdx = text.lastIndexOf(m);
          if (textIdx !== -1) result[title] = timeout;
        }
      }
    }
  }
  const longtime = Math.max.apply(null, Object.values(result));
  console.log("longTime : ", longtime);
  if (!Object.keys(result).length) return "(None)";
  return Object.keys(result).find((key) => result[key] === longtime);
}
