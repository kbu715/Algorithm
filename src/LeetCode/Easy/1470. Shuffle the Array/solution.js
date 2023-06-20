/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */
var shuffle = function (nums, n) {
  const firstPart = nums.slice(0, n);
  const secondPart = nums.slice(n);

  let result = [];
  for (let i = 0; i < n; i++) {
    result.push(firstPart[i]);
    result.push(secondPart[i]);
  }
  return result;
};
