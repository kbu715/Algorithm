function solution(number, k) {
  // number : [1, 9, 2, 4]
  const stack = [];
  let head = 0;

  stack.push(number[head++]);

  while (stack.length < number.length - k || head < number.length) {
    if (k && stack.length && stack[stack.length - 1] < number[head]) {
      stack.pop();
      k--;
      continue;
    }
    stack.push(number[head++]);
  }

  return stack.slice(0, number.length - k).join("");
}
