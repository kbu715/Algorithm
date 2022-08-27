function solution(s) {
  var answer = true;
  let stack = [];

  for (const x of s) {
    if (x === "(") stack.push(x);
    else if (x === ")" && !stack.includes("(")) stack.push(x);
    else stack.pop();
  }

  answer = stack.length > 0 ? false : true;

  return answer;
}
