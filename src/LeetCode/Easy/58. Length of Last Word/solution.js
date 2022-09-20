/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function (s) {
  const arr = s.trim().split(" ");
  const n = arr.length;
  return arr[n - 1].length;
};
