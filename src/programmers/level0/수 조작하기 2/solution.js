function solution(numLog) {
  return numLog
    .map((v, i) => {
      if (i === 0) return "";
      const prevNum = numLog[i - 1];
      if (prevNum + 1 === v) return "w";
      else if (prevNum - 1 === v) return "s";
      else if (prevNum + 10 === v) return "d";
      else if (prevNum - 10 === v) return "a";
      else return "";
    })
    .join("");
}
