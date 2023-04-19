function solution(n) {
  return n
    .toString()
    .split("")
    .map((v) => +v)
    .reduce((a, b) => a + b, 0);
}
