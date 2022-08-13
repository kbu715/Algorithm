function solution(x, n) {
  let answer = [];

  answer = Array.from({ length: n }, () => x).map((x, i) => x * (i + 1));

  return answer;
}
