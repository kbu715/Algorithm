function solution(number, k) {
  const stack = [];
  let pointer = 0;

  stack.push(number[pointer]);
  pointer++;

  while (stack.length < number.length - k || pointer < number.length) {
    if (k && stack.length && stack[stack.length - 1] < number[pointer]) {
      stack.pop();
      k--;
      continue;
    }
    stack.push(number[pointer]);
    pointer++;
  }

  return stack.slice(0, number.length - k).join("");
}

// Time Complexity : O(N) 목표
