function solution(land) {
  if (land.length === 1) return Math.max(...land[0]);
  const dp = [[...land[0]]]; // 초기 dp제작
  for (let i = 1; i < land.length; i++) {
    dp.push(new Array(4).fill(0));
  }
  for (let i = 1; i < land.length; i++) {
    // dp채우기
    dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2], dp[i - 1][3]) + land[i][0];
    dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2], dp[i - 1][3]) + land[i][1];
    dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][3]) + land[i][2];
    dp[i][3] = Math.max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + land[i][3];
  }
  console.log(dp);
  return Math.max(...dp[land.length - 1]);
}

// dp
// 점화식을 세우기
// f(n)의 x번째 값 = f(n-1)에서 x번째 값을 제외한 값들 중 최댓값 + land(n)의 x번째 값!!!
// dp 배열은 누적 최대값 배열 (행이 내려갈수록 값이 커진다)
