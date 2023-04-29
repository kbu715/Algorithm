function solution(binomial) {
  const arr = binomial.split(" ");

  return getOperator(arr[1], +arr[0], +arr[2]);
}

function getOperator(c, a, b) {
  switch (c) {
    case "+":
      return a + b;
    case "-":
      return a - b;
    case "*":
      return a * b;
    default:
      break;
  }
}
