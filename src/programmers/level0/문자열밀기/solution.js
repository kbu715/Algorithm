function solution(A, B) {
  const len = A.length;

  let cnt = 0;
  let temp = "";

  if (A === B) return 0;

  while (cnt < len) {
    temp = A.slice(len - 1) + A.slice(0, len - 1);
    if (temp === B) return cnt + 1;

    A = temp;
    cnt++;
  }

  return -1;
}
