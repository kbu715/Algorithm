function solution(n, words) {
  let mySet = new Set();

  mySet.add(words[0]);

  for (let i = 1; i < words.length; i++) {
    const prev = words[i - 1];
    const curr = words[i];

    if (mySet.has(curr)) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    } else if (prev[prev.length - 1] !== curr[0]) {
      return [(i % n) + 1, Math.floor(i / n) + 1];
    }
    mySet.add(curr);
  }

  return [0, 0];
}
