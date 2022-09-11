function solution(s) {
  let answer = 0;

  for (let i = 0; i < s.length; i++) {
    // s의 길이만큼 회전

    if (isValid(s)) answer++;
    // 왼쪽으로 회전
    s = s.slice(1) + s[0];
  }

  return answer;
}

function isValid(s) {
  let temp = [...s];
  let stack = [];
  let curr, prev;

  stack.push(temp[0]);

  for (let i = 1; i < temp.length; i++) {
    curr = temp[i];
    prev = stack[stack.length - 1];

    if (
      (curr === ")" && prev === "(") ||
      (curr === "}" && prev === "{") ||
      (curr === "]" && prev === "[")
    ) {
      stack.pop();
    } else stack.push(curr);
  }

  if (stack.length === 0) return true;
  else return false;
}
