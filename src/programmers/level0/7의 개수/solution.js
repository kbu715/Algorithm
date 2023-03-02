function solution(array) {
  return array
    .reduce((a, c) => a + String(c), "")
    .split("")
    .filter((v) => Number(v) === 7).length;
}
