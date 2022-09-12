function solution(n, left, right) {
  return Array.from({ length: right - left + 1 }, () => left).map(
    (v, i) => Math.max(Math.floor((v + i) / n), (v + i) % n) + 1
  );
}
