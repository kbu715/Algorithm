function solution(arr) {
  const answer = [];
  const len = arr.length;

  let i = 0;
  while (len > 2 ** i) {
    i++;
  }

  arr.forEach((v) => {
    answer.push(v);
  });

  for (let j = 0; j < 2 ** i - len; j++) {
    answer.push(0);
  }

  return answer;
}
