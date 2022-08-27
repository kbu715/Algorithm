function solution(a, b) {
  let answer = [];

  for (let i = 0; i < a.length; i++) {
    let temp = [];
    for (let j = 0; j < b[0].length; j++) {
      let sum = 0;

      for (let k = 0; k < b.length; k++) {
        sum += a[i][k] * b[k][j];
      }
      temp.push(sum);
    }
    answer.push(temp);
  }

  return answer;
}
