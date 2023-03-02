function solution(n) {
  var answer = [];

  answer = Array.from({ length: n }, (_, i) => i + 1).filter(
    (v) => v % 2 === 1
  );

  return answer;
}
