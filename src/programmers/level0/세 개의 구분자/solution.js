function solution(myStr) {
  var answer = [];
  const regex = /[a|b|c]/;

  answer = myStr.split(regex).filter((v) => v);
  return answer.length === 0 ? ["EMPTY"] : answer;
}
