function solution(n) {
  let answer = -1;

  let str = "";

  for (let i = 1; i <= n; i++) {
    str += String(i);
  }

  answer = +str[n - 1];

  return answer;
}
