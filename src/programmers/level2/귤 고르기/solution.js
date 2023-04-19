function solution(k, tangerine) {
  function getLookup(arr) {
    let obj = {};

    for (const x of arr) {
      if (!obj[x]) {
        obj[x] = 1;
      } else {
        obj[x] = obj[x] + 1;
      }
    }
    return obj;
  }

  const lookup = getLookup(tangerine);

  tangerine.sort((a, b) => {
    if (lookup[a] !== lookup[b]) return lookup[b] - lookup[a];
    return b - a;
  });

  return new Set(tangerine.slice(0, k)).size;
}
