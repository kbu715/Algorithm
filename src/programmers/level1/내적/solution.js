function solution(a, b) {
  let answer = 1234567890;

  let total = 0;

  for (let i = 0; i < a.length; i++) {
    
    total += a[i] * b[i];
  }


  answer = total;
  return answer;
}