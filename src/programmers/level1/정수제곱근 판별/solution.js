function solution(n) {
  let answer = 0;
  answer = n % Math.sqrt(n) == 0 ? Math.pow(Math.sqrt(n)+1, 2) : -1;
  return answer;
}