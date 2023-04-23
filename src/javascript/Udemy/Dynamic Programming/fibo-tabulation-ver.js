// 상향식 접근
function fib(n) {
  if (n <= 2) return 1;
  const fibNums = [0, 1, 1];

  for (let i = 3; i <= n; i++) {
    fibNums[i] = fibNums[i - 1] + fibNums[i - 2];
  }

  return fibNums[n];
}

// Maximum Call Stack Error 방지
