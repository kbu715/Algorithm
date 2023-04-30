function solution(arr, queries) {
  queries.forEach((query) => {
    const [s, e] = query;
    arr = arr.map((v, i) => (i >= s && i <= e ? v + 1 : v));
  });
  return arr;
}
