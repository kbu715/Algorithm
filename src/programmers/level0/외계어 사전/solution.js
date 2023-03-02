function solution(spell, dic) {
  const sorted = dic.map((word) => word.split("").sort().join(""));
  const searchWord = spell.sort().join("");

  if (sorted.includes(searchWord)) return 1;
  return 2;
}
