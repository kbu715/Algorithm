function solution(citations) {
  citations = citations.sort((a, b) => b - a); // desc
  let max = Math.max(...citations);

  for (let h = max; h >= 0; h--) {
    if (citations.filter((c) => c >= h).length >= h) {
      return h;
    }
  }
}
