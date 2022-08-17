function solution(left, right) {
  let answer = 0;

  for (let i = left; i <= right; i++) {
    answer += getDivisorCount(i) % 2 === 0 ? i : i * -1;
  }

  return answer;
}

function getDivisorCount(num) {
  let count = 0;
  for (let i = 1; i <= num; i++) {
    if (num % i === 0) {
      count++;
    }
  }
  return count;
}
