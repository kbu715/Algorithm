function fib(n, memo = [undefined, 1, 1]) {
  if (memo[n] !== undefined) return memo[n];

  const res = fib(n - 1, memo) + fib(n - 2, memo);
  memo[n] = res;
  return res;
}

// Time Complexity - O(n)
