function solution(numbers, target) {
  let answer = 0;
  let n = numbers.length;

  function DFS(v, sum) {
    if (v === n) {
      if (sum === target) answer++;
      return;
    } else {
      DFS(v + 1, sum + numbers[v]);
      DFS(v + 1, sum - numbers[v]);
    }
  }

  DFS(0, 0);

  return answer;
}
