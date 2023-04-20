function solution(X, Y) {
  let result = "";
  const lookup = {};

  for (const char of X) {
    lookup[char] = (lookup[char] || 0) + 1;
  }

  for (const char of Y) {
    if (!lookup[char]) continue;
    result += char;
    lookup[char]--;
  }

  if (result === "") return "-1";
  if (+result === 0) return "0";
  return [...result]
    .map((num) => +num)
    .sort((a, b) => b - a)
    .join("");
}
