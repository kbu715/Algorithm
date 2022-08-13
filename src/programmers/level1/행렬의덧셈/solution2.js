function solution(arr1, arr2) {
  let answer = [];

  let r = arr1.length;
  let c = arr1[0].length;

  for (let i = 0; i < r; i++) {
    let temp = [];
    for (let j = 0; j < c; j++) {
      let result = arr1[i][j] + arr2[i][j];
      temp = [...temp, result];
    }
    answer = [...answer, temp];
  }

  return answer;
}
