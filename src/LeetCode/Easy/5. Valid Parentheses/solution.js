/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  let stack = [];
  for (const x of s) {
    if (stack.length === 0) {
      if ((stack.length === 0 && x === ")") || x === "}" || x === "]")
        return false;
      else stack.push(x);
    } else {
      if (
        (x === ")" && stack[stack.length - 1] === "(") ||
        (x === "}" && stack[stack.length - 1] === "{") ||
        (x === "]" && stack[stack.length - 1] === "[")
      ) {
        stack.pop();
      } else stack.push(x);
    }
  }

  return stack.length === 0;
};
