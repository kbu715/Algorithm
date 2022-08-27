function solution(n) {
  let answer = 0;
  let origin = n;

  function getLength(n) {
    return n
      .toString(2)
      .split("")
      .filter((v) => v === "1").length;
  }

  while (true) {
    n++;
    if (getLength(n) === getLength(origin)) {
      answer = n;
      break;
    }
  }
  return answer;
}
