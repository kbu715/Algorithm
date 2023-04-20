function solution(number, k) {
  // number : [1, 9, 2, 4]
  let stack = [];

  let arr = number.split("").reverse(); // [4, 2, 9, 1]

  while (arr.length && k > 0) {
    stack.push(arr.pop());

    while (
      stack.length &&
      stack[stack.length - 1] < arr[arr.length - 1] &&
      k > 0
    ) {
      stack.pop();
      k = k - 1;
    }
  }

  if (k !== 0) stack = stack.slice(0, -k);

  return stack.join("") + arr.reverse().join("");
}
