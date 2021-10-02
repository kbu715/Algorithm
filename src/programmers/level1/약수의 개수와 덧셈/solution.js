function solution(left, right) {
  let answer = 0;


  for (let i = left; i <= right; i++) {
    if (isOdd(getDivisor(i))) answer -= i;
    else answer += i;
  }


  function getDivisor(num) {
    let count = 0;
    for (let i = 1; i <= num; i++) {
      if (num % i == 0) count++;
    }
    return count;
  }

  function isOdd(num) {
    return num % 2 == 0 ? false : true;
  }

  return answer;
}