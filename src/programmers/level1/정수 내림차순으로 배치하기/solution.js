function solution(n) {
  let answer = 0;

  let str = n.toString();

  let temp = "";
  Array.from(str).sort((a, b) => b - a).forEach(v => {
    temp += v;
  })

  answer = parseInt(temp);

  return answer;
}