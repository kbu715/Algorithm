function solution(k, score) {
  let answer = [];
  let temp = [];

  function getHallOfFame(score) {
    temp.push(score);
    temp.sort((a, b) => b - a);
    if (temp.length > k) {
      temp = temp.slice(0, k);
    }
    return temp;
  }

  for (let i = 0; i < score.length; i++) {
    const hof = getHallOfFame(score[i]);
    answer.push(hof[hof.length - 1]);
  }

  return answer;
}
