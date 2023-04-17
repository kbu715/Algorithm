/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
  const filtered = nums.filter((v) => v !== val);
  let i = 0;
  for (const x of filtered) {
    nums[i] = x;
    i++;
  }

  return filtered.length;
};
