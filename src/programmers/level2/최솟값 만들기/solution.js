function solution(A, B) {
  let answer = 0;

  A.sort((a, b) => a - b);
  B.sort((a, b) => b - a);

  answer = A.map((v, index) => v * B[index]).reduce((a, b) => a + b, 0);

  return answer;
}
