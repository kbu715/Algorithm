function solution(n, m) {
  let answer = [];

  let G = 0; // 최대공약수
  let L = 0; // 최소공배수

  let GT = n > m ? n : m;

  // #1 최대공약수 구하기
  for (let i = 1; i < GT; i++) {
    if (n % i == 0 && m % i == 0) {
      G = i;
    }
  }

  // #2 최소공배수 구하기
  // 두 수의 곱 = 최대공약수 x 최소공배수

  L = n * m / G;

  answer = [G, L];

  return answer;
}