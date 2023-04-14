function solution(s) {
  let answer = [];
  let visited = [];

  for (let i = 0; i < s.length; i++) {
    if (!visited.includes(s[i])) {
      visited.push(s[i]);
      answer.push(-1);
    } else {
      answer.push(i - visited.lastIndexOf(s[i]));
      visited.push(s[i]);
    }
  }

  return answer;
}
