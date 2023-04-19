function solution(compressed) {
  var answer = "";

  let s = compressed;

  let stack = [];
  const regex = /[0-9]/;

  for (const x of s) {
    if (
      stack.length > 0 &&
      regex.test(stack[stack.length - 1]) &&
      regex.test(x)
    )
      stack.push(Number(stack.pop() + x));
    else if (regex.test(x)) stack.push(+x);
    else if (x === "(") stack.push(x);
    else if (x === ")") {
      let temp = [];
      while (stack[stack.length - 1] !== "(") {
        temp.unshift(stack.pop());
      }
      stack.pop(); // '('
      stack.push(temp.join("").repeat(stack.pop()));
    } else {
      stack.push(x);
    }
  }

  console.log(stack);

  answer = stack.join("");

  return answer;
}
