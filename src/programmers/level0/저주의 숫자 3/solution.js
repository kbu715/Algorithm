function solution(n) {
  return get3X(n);
}

function get3X(n) {
  let cnt = 0;

  for (let i = 1; i <= n; i++) {
    cnt++;
    while (cnt % 3 === 0 || String(cnt).indexOf("3") >= 0) {
      cnt++;
    }
  }

  return cnt;
}
