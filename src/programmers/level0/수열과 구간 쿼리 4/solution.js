function solution(arr, queries) {
  var answer = [...arr];

  for (const q of queries) {
    const [s, e, k] = q;
    answer = answer.map((v, i) => {
      if (i >= s && i <= e && i % k === 0) return v + 1;
      else return v;
    });
  }
  return answer;
}
