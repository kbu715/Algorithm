/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
  const roman = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
  };
  const nums = s.split("").map((value) => roman[value]);

  let answer = 0;

  for (let i = 0; i < nums.length; i++) {
    if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
      answer += nums[i + 1] - nums[i];
      i++;
    } else {
      answer += nums[i];
    }
  }
  return answer;
};
