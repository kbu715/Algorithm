function isPrime(num) {
  if (!num || num === 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}

function solution(n, k) {
  // k진법으로 나눈 후 split
  const nums = n.toString(k).split("0");
  // 소수 개수 세기
  return nums.filter((v) => isPrime(+v)).length;
}
