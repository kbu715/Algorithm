function solution(numbers) {
  var answer = -1;

  let temp = Array.from({ length: 10 }, (v, i) => i);
  let total = temp.reduce((a, b) => a + b, 0); // 45

  answer = total - numbers.reduce((a, b) => a + b, 0);

  return answer;
}
