function solution(absolutes, signs) {
  var answer = 123456789;

  answer = absolutes
    .map((v, i) => (signs[i] ? v : v * -1))
    .reduce((a, b) => a + b, 0);

  return answer;
}
