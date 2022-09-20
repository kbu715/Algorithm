/**
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
  if (nums.includes(target)) return nums.indexOf(target);
  else {
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] <= target) continue;
      else return i;
    }
    return nums.length;
  }
};
