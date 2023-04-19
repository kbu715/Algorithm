function solution(n) {
  return n
    .toString()
    .split("")
    .map((v) => +v)
    .reverse();
}
