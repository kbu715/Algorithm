function solution(arr, divisor) {
  let answer = [];

  let temp = arr.filter((v) => v % divisor === 0).sort((a, b) => a - b);

  if (temp.length === 0) answer.push(-1);
  else answer = temp;

  return answer;
}