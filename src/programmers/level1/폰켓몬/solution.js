function solution(nums) {
  const max = nums.length / 2;

  const mySet = new Set(nums);

  return mySet.size > max ? max : mySet.size;
}
