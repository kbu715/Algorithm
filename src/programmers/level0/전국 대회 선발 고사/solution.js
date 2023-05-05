function solution(rank, attendance) {
  const [a, b, c] = rank
    .map((r, idx) => ({
      rank: r,
      index: idx,
    }))
    .filter((_, i) => attendance[i])
    .sort((a, b) => a.rank - b.rank)
    .map((obj) => obj.index);

  return 10000 * a + 100 * b + c;
}
