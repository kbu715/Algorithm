function solution(arr) {
  const newArr = arr.map(
    (num) =>
      num
        .toString()
        .split("")
        .sort()
        .reduce((a, c) => a + c),
    ""
  );
  return new Set(newArr).size;
}
