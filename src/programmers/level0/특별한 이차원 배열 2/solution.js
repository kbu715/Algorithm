function solution(arr) {
  let answer = 1;

  outer: for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      if (i === j) continue;

      if (arr[i][j] !== arr[j][i]) {
        answer = 0;
        break outer;
      }
    }
  }

  return answer;
}
