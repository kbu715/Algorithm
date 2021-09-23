function solution(num) {
  let answer = 0;

  let cnt = 0;

  while (num !== 1 && cnt <= 500) {
    cnt++;
    if (num % 2 == 0) num /= 2;
    else {
      num *= 3;
      num++;
    }
  }

  answer = cnt > 500 ? -1 : cnt;
  return answer;
}