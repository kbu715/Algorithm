function solution(d, budget) {
  let answer = 0;

  d.sort((a, b) => a - b);
  let sum = 0;
  while (sum <= budget) {
    sum += d[answer++];
  }

  answer--;

  return answer;
}
