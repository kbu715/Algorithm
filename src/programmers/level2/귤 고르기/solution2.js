// 다른 사람 풀이
function solution(k, tangerine) {
  let answer = 0;
  const tDict = {};
  tangerine.forEach((t) => (tDict[t] = (tDict[t] || 0) + 1));
  const tArr = Object.values(tDict).sort((a, b) => b - a); // [2, 2, 2, 1, 1]
  for (const t of tArr) {
    answer++;
    if (k > t) k -= t;
    else break;
  }
  return answer;
}
