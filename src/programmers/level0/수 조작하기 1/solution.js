function solution(n, control) {
  for (const c of control) {
    n += getNumber(c);
  }

  return n;
}

function getNumber(c) {
  switch (c) {
    case "w":
      return 1;
    case "s":
      return -1;
    case "d":
      return 10;
    case "a":
      return -10;
  }
}
