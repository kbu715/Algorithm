function solution(a, b) {
  let answer = 0;
  let sum = 0;
  if (a > b) {
    for (let i = b; i <= a; i++) {
      sum += i;
      answer = sum;
    }
  } else if (b > a) {
    for (let i = a; i <= b; i++) {
      sum += i;
      answer = sum;
    }
  } else answer = a;

  return answer;
}