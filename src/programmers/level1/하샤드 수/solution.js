function solution(x) {
  let answer = true;

  let strNum = x.toString();

  let sum = 0;

  for (const c of strNum) {
    sum += parseInt(c);
  }

  answer = x % sum == 0 ? true : false;


  return answer;
}