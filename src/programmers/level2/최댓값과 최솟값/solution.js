function solution(s) {
  let answer = "";

  const numbers = s.split(" ");

  answer = `${Math.min(...numbers)} ${Math.max(...numbers)}`;

  return answer;
}
