function isPrime(num) {
  let result = true;

  if (num === 1) return false;

  for (let i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
    if (num % i === 0) return false;
  }

  return result;
}
function solution(n) {
  let answer = 0;

  for (let j = 2; j <= n; j++) {
    if (isPrime(j)) {
      answer++;
    }
  }

  return answer;
}
