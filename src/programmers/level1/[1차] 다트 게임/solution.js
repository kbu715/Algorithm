function solution(dartResult) {
  const answer = [];

  for (let i = 0; i < dartResult.length; i++) {
    const c = dartResult[i];
    if (dartResult[i] + dartResult[i + 1] === "10") {
      answer.push(Number(dartResult[i] + dartResult[i + 1]));
      i++;
      continue;
    }
    if (!isNaN(c)) {
      answer.push(c);
    } else {
      if (c === "S") {
        answer[answer.length - 1] = Math.pow(answer[answer.length - 1], 1);
      } else if (c === "D") {
        answer[answer.length - 1] = Math.pow(answer[answer.length - 1], 2);
      } else if (c === "T") {
        answer[answer.length - 1] = Math.pow(answer[answer.length - 1], 3);
      } else {
        if (c === "*") {
          if (answer.length > 1) {
            answer[answer.length - 2] = answer[answer.length - 2] * 2;
          }
          answer[answer.length - 1] = answer[answer.length - 1] * 2;
        } else {
          // #
          answer[answer.length - 1] = answer[answer.length - 1] * -1;
        }
      }
    }
  }
  return answer.reduce((a, c) => a + c);
}
