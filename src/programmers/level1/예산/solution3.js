function solution(d, budget) {
  var answer = 0;

  d.sort((a, b) => a - b);

  while (d.reduce((a, b) => a + b, 0) > budget) d.pop();

  answer = d.length;

  return answer;
}
