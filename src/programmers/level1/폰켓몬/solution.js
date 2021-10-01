function solution(nums) {
  const max = nums.length / 2;

  const set = new Set(nums);


  return set.size > max ? max : set.size;
}