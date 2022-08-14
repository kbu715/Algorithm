function solution(s) {
  let n = s.length;

  if (n !== 4 && n !== 6) return false;

  return s.split("").every((c) => !isNaN(c));
}
