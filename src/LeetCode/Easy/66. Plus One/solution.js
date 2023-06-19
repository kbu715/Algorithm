/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {
  return (Number(digits.join("")) + 1).toString().split("").map(Number);
};
