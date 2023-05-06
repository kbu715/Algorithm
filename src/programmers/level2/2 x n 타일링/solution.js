function solution(n) {
  const mod = 10 ** 9 + 7;

  const dp = Array(n).fill(0);

  dp[0] = 1;
  dp[1] = 1;

  for (let i = 2; i < n + 1; i++) {
    dp[i] = (dp[i - 2] + dp[i - 1]) % mod;
  }
  return dp[n];
}
