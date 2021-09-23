function solution(x, n) {
  let answer = [];

  const gap = x;
  for (let i = 0; i < n; i++) {
    answer.push(x);
    x += gap;
  }

  console.log(answer);

  return answer;
}