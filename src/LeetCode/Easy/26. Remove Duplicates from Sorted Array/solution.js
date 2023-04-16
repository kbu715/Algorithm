/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  const set = new Set(nums);
  let i = 0;
  for (const x of set) {
    nums[i] = x;
    i++;
  }

  return set.size;
};
