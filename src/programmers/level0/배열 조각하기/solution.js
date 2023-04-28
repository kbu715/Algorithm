function solution(arr, query) {
  // Two Pointer
  let start = 0;
  let end = arr.length - 1;

  for (const q of query) {
    if (q % 2 === 0) {
      end = start + q;
    } else {
      start = start + q;
    }
  }

  return arr.slice(start, end + 1);
}
