function solution(nums) {
  let answer = 0;
  let n = nums.length;
  let selected = [];

  function isPrime(n) {
    if (n === 1) return false;

    for (let i = 2; i <= Math.floor(Math.sqrt(n)); i++) {
      if (n % i === 0) return false;
    }
    return true;
  }

  function DFS(L, start, sum) {
    if (L === 3) {
      console.log(sum);
      if (isPrime(sum)) answer++;
    } else {
      for (let i = start; i < n; i++) {
        selected.push(nums[i]);
        DFS(L + 1, i + 1, sum + nums[i]);
        selected.pop();
      }
    }
  }

  DFS(0, 0, 0);

  return answer;
}
