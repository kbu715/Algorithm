function solution(scores) {
  let answer = '';

  let len = scores.length;

  for (let c = 0; c < len; c++) {
      let temp = [];
      for (let r = 0; r < len; r++) {
        temp.push(scores[r][c]);
      }
    let max = getMax(temp);
    let min = getMin(temp);

    // 유일한 최고점 혹은 유일한 최저점이면 삭제
    if (temp.filter(v => v === max).length === 1 && c === temp.findIndex(v => v === max)) {
      temp.splice(c, 1);
    } else if (temp.filter(v => v === min).length === 1 && c === temp.findIndex(v => v === min)) {
      temp.splice(c, 1);
    }

    answer += grade(getAvg(temp));
  }


  // 학점변환 함수
  function grade(avg) {
    if (avg >= 90) return 'A';
    if (avg >= 80 && avg < 90) return 'B';
    if (avg >= 70 && avg < 80) return 'C';
    if (avg >= 50 && avg < 70) return 'D';
    else return 'F';
  }

  // 평균구하는 함수
  function getAvg(arr) {
    return arr.reduce((acc, val) => acc + val, 0) / arr.length;
  }

  // 최고점 구하기
  function getMax(arr) {
    return Math.max(...arr);
  }

    // 최저점 구하기
    function getMin(arr) {
      return Math.min(...arr);
    }

  return answer;
}