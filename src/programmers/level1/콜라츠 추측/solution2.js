function solution(num) {
  let answer = 0;
  let temp = num;

  while (temp !== 1) {
    if (answer === 500) {
      answer = -1;
      break;
    }
    if (temp % 2 === 0) {
      temp = temp / 2;
    } else {
      temp = temp * 3 + 1;
    }
    answer++;
  }

  return answer;
}
