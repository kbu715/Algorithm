function solution(X, Y) {
  let answer = "";

  let xArr = X.split("");
  let yArr = Y.split("");
  xArr.sort();
  yArr.sort();
  let jjak = [];

  let xIdx = 0;
  let yIdx = 0;

  while (xIdx < xArr.length && yIdx < yArr.length) {
    if (xArr[xIdx] === yArr[yIdx]) {
      jjak.push(xArr[xIdx]);
      xIdx++;
      yIdx++;
    } else if (xArr[xIdx] > yArr[yIdx]) {
      yIdx++;
    } else {
      xIdx++;
    }
  }

  if (jjak.length === 0) return "-1";
  else if (+jjak.join("") === 0) return "0";
  else {
    answer = jjak.sort((a, b) => b - a).join("");
  }

  return answer;
}
