function solution(n, k) {
  let answer = 0;
  const arr = n
    .toString(k)
    .split("0")
    .map((v) => +v)
    .filter((v) => v !== 0);
  const len = arr.length;
  answer = arr.filter(
    (v, i) =>
      (i === 0 && isPrime(v)) ||
      (i === len - 1 && isPrime(v)) ||
      (i !== 0 && i !== len - 1 && isPrime(v))
  ).length;
  // 211020101011

  return answer;
}

function isPrime(n) {
  if (n === 1) return false;
  if (n === 2) return true;

  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) return false;
  }
  return true;
}
