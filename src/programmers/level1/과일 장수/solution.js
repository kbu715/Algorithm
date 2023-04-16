function solution(k, m, score) {
  let answer = 0;

  // 내림차순 정렬
  score.sort((a, b) => b - a);

  if (score.length < m) return 0;

  for (let i = m - 1; i < score.length; i += m) {
    answer += score[i] * m;
  }

  return answer;
}
