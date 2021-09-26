function solution(n) {
  let arr = [];
  let cnt = 0;

  // 에라토스테네스의 체

  arr = Array.from({ length: n + 1 }, () => true);
;
  for (let i = 2; i * i <= n; i++) {
    if (arr[i]) {
      for (let j = i * i; j <= n; j += i) {
        arr[j] = false;
      }
    }
  }
  arr.splice(0, 2, false, false); // 0과 1은 false;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i]) cnt++;
  }

  return cnt++;
}