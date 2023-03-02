function solution(n) {
  const sqrt = Math.sqrt(n);
  if (sqrt === Math.floor(sqrt)) return 1;

  return 2;
}
