function solution(s) {
  let answer = 0;

  let stack = [];

  for (const x of s) {
    if (stack.length === 0) stack.push(x);
    else {
      if (stack[stack.length - 1] === x) stack.pop();
      else stack.push(x);
    }
  }

  if (stack.length === 0) answer = 1;

  return answer;
}
