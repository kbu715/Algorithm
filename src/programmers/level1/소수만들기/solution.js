function solution(nums) {
  let answer = -1;

  let selected = Array.from({ length: 3 });
  let count = 0;

  comb(0, 0);

  answer = count;

  function comb(cnt, start) {
    if (cnt === 3) {
      let temp = selected.reduce((acc, cur) => acc + cur, 0);

      if (isPrime(temp)) {
        count++;
      }

      return;
    }
    for (let i = start; i < nums.length; i++) {
      
      selected[cnt] = nums[i];
      comb(cnt + 1, i + 1);

    }

  }

  function isPrime(n) {
    if (n === 1) {
      return false;
    }

    for (let i = 2; i < n; i++) {
      if (n % i === 0) {
        return false;
      }
    }
    return true;
  }
  
  return answer;
}