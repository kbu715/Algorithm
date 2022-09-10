function solution(n) {
  let ans = 0;

  // 역으로 생각!
  while (n >= 1) {
    // 0에서 6이 도착지점인 상황으로 생각해보면
    // 6 -> 3 -> 2 -> 1 -> 0
    // 6 -> 3 이 첫번째 조건에 해당하고
    // 3 -> 2 -> 1 이 두번째 조건에 해당, ans++
    // 1 -> 0 두번째 조건에 해당, ans++
    // 정답은 solution(6) = 2
    if (n % 2 === 0) n = n / 2;
    else {
      n = (n - 1) / 2;
      ans++;
    }
  }

  return ans;
}
