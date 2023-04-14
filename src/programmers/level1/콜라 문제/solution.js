function solution(a, b, n) {
  let answer = 0;
  let currentGetCoke;

  while (true) {
    if (n < a) break;

    currentGetCoke = Math.floor(n / a) * b;
    answer += currentGetCoke;
    n = (n % a) + currentGetCoke;
    console.log(n);
  }
  return answer;
}
