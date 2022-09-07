function solution(s) {
  let zeroCount = 0,
    count = 0;

  while (s !== "1") {
    for (const x of s) {
      if (x === "0") zeroCount++;
    }
    s = s.replaceAll("0", "");
    s = s.length.toString(2);

    count++;
  }

  return [count, zeroCount];
}
