function solution(balls, share) {
  let answer = 0;
  const n = balls;
  const r = share;

  // n * (n-1) * ... * (n - r + 1) === nPr
  // -----------------------------
  //              r!

  answer = perm(n, r) / fact(r);

  answer = Math.floor(answer);

  return answer;
}

function perm(n, r) {
  // Permutation
  let result = 1;
  for (let i = n; i >= n - r + 1; i--) {
    result *= i;
  }
  return result;
}

function fact(n) {
  // Factorial
  let result = 1;
  for (let i = n; i > 1; i--) {
    result *= i;
  }
  return result;
}
