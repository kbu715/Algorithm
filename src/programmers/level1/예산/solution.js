function solution(d, budget) {
  let answer = 0;
  let total = 0;
  d.sort((a, b) => a - b); // 오름차순
  for (const key in d) {
    if (total+d[key] <= budget) {
      total += d[key]
      answer++;
    }
  }
  return answer;
}