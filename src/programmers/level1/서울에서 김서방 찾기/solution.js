function solution(seoul) {
  let answer = '';

  let idx = seoul.findIndex((v) => v == 'Kim');


  answer = `김서방은 ${idx}에 있다`

  return answer;
}