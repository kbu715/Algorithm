function solution(score) {
  let answer = [];
  const avgs = score.map((one) => (one[0] + one[1]) / 2); // 평균

  const sorted = [...avgs].sort((a, b) => b - a); // 내림차순

  for (const avg of avgs) {
    answer.push(sorted.indexOf(avg) + 1);
  }
  return answer;
}
