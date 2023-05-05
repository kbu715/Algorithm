function solution(arr, queries) {
  var answer = [];
  for (const query of queries) {
    const [s, e, k] = query;

    let min = Infinity;
    for (let i = 0; i < arr.length; i++) {
      if (i >= s && i <= e && arr[i] > k) {
        min = Math.min(min, arr[i]);
      }
    }
    if (min === Infinity) {
      answer.push(-1);
      continue;
    }
    answer.push(min);
  }
  return answer;
}
