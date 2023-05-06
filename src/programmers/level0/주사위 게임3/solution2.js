function count(arr) {
  const counter = new Map();
  for (const num of arr) {
    counter.set(num, (counter.get(num) || 0) + 1);
  }
  const sortedByCnt = [...counter.keys()].sort(
    (a, b) => counter.get(b) - counter.get(a)
  );
  const maxCnt = Math.max(...counter.values());
  return [sortedByCnt, maxCnt];
}

function solution(a, b, c, d) {
  const [arr, maxCnt] = count([a, b, c, d]);
  const [p, q, r, s] = arr;
  if (arr.length === 1) {
    return p * 1111;
  }
  if (arr.length === 2) {
    // 2/2 or 3/1
    return maxCnt === 2 ? (p + q) * Math.abs(p - q) : (10 * p + q) ** 2;
  }
  if (arr.length === 3) {
    // 2/1/1
    return q * r;
  }
  return Math.min(p, q, r, s);
}
