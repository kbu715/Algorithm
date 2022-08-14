function solution(numbers) {
  var answer = [];
  let n = numbers.length,
    r = 2;

  let selected = [];
  let set = new Set();

  function DFS(L, start) {
    if (L === r) {
      set.add(selected[0] + selected[1]);
    } else {
      for (let i = start; i < n; i++) {
        selected.push(numbers[i]);
        DFS(L + 1, i + 1);
        selected.pop();
      }
    }
  }

  DFS(0, 0);
  answer = Array.from(set).sort((a, b) => a - b);

  return answer;
}
