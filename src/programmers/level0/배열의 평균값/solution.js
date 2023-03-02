function solution(numbers) {
  let answer = 0;

  const total = numbers.reduce((a, c) => a + c, 0);

  answer = total / numbers.length;

  return answer;
}
