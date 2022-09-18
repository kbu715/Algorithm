/**
 * @param {string[]} strs
 * @return {string}
 */
const longestCommonPrefix = function (strs) {
  if (!strs.length) return "";
  let answer = "";

  let prefixMaxLength = Math.min(...strs.map((str) => str.length));

  for (let i = 0; i < prefixMaxLength; i++) {
    let ch = strs[0][i];
    if (strs.every((str) => str[i] === ch)) answer += ch;
    else break;
  }

  return answer;
};

// O(n)
