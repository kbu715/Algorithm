function solution(x) {
  var answer = true;

  let divider = x
    .toString()
    .split("")
    .map((v) => +v)
    .reduce((a, b) => a + b, 0);

  answer = x % divider === 0;

  return answer;
}
