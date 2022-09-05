function solution(n) {
  var answer = 0;

  answer = getDecimal(n.toString(3).split("").reverse().join(""));

  return answer;
}

function getDecimal(str) {
  let stack = str.split("").map((v) => +v);
  let n = stack.length;

  let result = 0;

  for (let i = 0; i < n; i++) {
    result += stack.pop() * Math.pow(3, i);
  }
  return result;
}
