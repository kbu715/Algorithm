function solution(strArr) {
  const strLens = strArr.map((str) => str.length);

  const lookup = {};
  for (const len of strLens) {
    lookup[len] = (lookup[len] || 0) + 1;
  }

  return Math.max(...Object.values(lookup));
}
