/**
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */
var gcdOfStrings = function (str1, str2) {
  if (str1 + str2 !== str2 + str1) return ""; // abcabc abc

  let isValidate = (word, str) => {
    if (str.length == 0) return true;
    if (!str.startsWith(word)) return false;
    return isValidate(word, str.slice(word.length));
  };

  let result = "";

  for (let i = 1; i <= str1.length; i++) {
    let currWord = str1.slice(0, i);
    if (isValidate(currWord, str2) && isValidate(currWord, str1))
      result = currWord;
  }

  return result;
};
