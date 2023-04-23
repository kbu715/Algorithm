function solution(s) {
  let answer = 0;
  let x = s[0],
    xCnt = 0,
    xNotCnt = 0;

  let i = 0;
  for (const c of s) {
    if (c === x) {
      xCnt++;
    } else {
      xNotCnt++;
    }
    if (xCnt === xNotCnt) {
      answer++;
      x = s[i + 1];
      xCnt = 0;
      xNotCnt = 0;
    }
    i++;
  }

  if (xCnt !== xNotCnt) answer++;

  return answer;
}
