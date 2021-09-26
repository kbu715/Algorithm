function solution(n) {
  let answer = [];

  let temp = n.toString().split('').map(v => parseInt(v)).reverse();

  answer = temp;

  return answer;
}