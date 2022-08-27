// memoization

function solution(n) {
  let answer = 0;
  let memo = [0, 1, 2];

  if (memo[n]) return memo[n];
  for (let i = 3; i <= n; i++) {
    memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
  }
  answer = memo[n];
  return memo[n];
}
