function solution(n) {
  let x = Math.sqrt(n);
  if (x !== Math.floor(x)) return -1;
  return Math.pow(x + 1, 2);
}
