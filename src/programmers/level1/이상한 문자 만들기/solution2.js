function solution(s) {
  let cnt = 0;
  let answer = s
    .split("")
    .map((ch) => {
      if (ch === " ") {
        cnt = 0;
        return ch;
      } else {
        return cnt++ % 2 === 0 ? ch.toUpperCase() : ch.toLowerCase();
      }
    })
    .join("");

  return answer;
}
