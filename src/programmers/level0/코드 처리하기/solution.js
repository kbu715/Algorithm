function solution(code) {
  var answer = "";
  let mode = 0;
  const codeArr = [...code];
  codeArr.forEach((c, idx) => {
    if (mode === 0) {
      if (c === "1") mode = 1;
      else {
        if (idx % 2 === 0) {
          answer += c;
        }
      }
    } else {
      if (c === "1") mode = 0;
      else {
        if (idx % 2 !== 0) {
          answer += c;
        }
      }
    }
  });

  return answer === "" ? "EMPTY" : answer;
}
