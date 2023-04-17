function hash(key, arrayLen) {
  let total = 0;
  // Prime Number 사용하는 이유 -> 수학적인 이유 (복잡함)
  let WEIRD_PRIME = 31;

  for (let i = 0; i < Math.min(key.length, 100); i++) {
    let char = key[i];
    let value = char.charCodeAt(0) - 96;
    total = (total * WEIRD_PRIME + value) % arrayLen; // mod
  }
  return total;
}
