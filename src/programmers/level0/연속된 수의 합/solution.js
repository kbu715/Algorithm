function solution(num, total) {
  let answer = [];

  const center = total / num;

  if (center === Math.floor(center)) answer.push(center);
  else {
    answer.unshift(Math.floor(center));
    answer.push(Math.ceil(center));
  }
  while (answer.length < num) {
    answer.unshift(answer[0] - 1);
    answer.push(answer[answer.length - 1] + 1);
  }

  return answer;
}
