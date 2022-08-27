function solution(n) {
  var answer = 0;
  let half = Math.floor(n / 2);
  for (let i = 1; i <= half; i++) {
    let sum = 0;
    for (let j = i; j <= n; j++) {
      sum += j;
      if (sum >= n) {
        if (sum === n) answer++;
        break;
      }
    }
  }
  return ++answer;
}
