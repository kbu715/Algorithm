function solution(n) {
  var answer = 0;

  let memo = [0, 1, 1, 2, 3, 5];

  if (n <= 5) return memo[n];
  else {
    for (let i = 6; i <= n; i++) {
      memo[i] = ((memo[i - 1] % 1234567) + (memo[i - 2] % 1234567)) % 1234567;
    }
  }

  answer = memo[n];

  return answer;
}
// 모든 단계에서 % 연산을 사용하여, 모든 연산에서 오버플로우가 일어나지 않게 만들기

// F(n) % m
// = (F(n-1) + F(n-2)) % m
// = (F(n-1) % m + F(n-2) % m) % m
