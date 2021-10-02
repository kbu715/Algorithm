function solution(answers) {
  let answer = [];

  let temp = Array.from(Array(3)).fill(0);

  let one = [1, 2, 3, 4, 5];
  let two = [2, 1, 2, 3, 2, 4, 2, 5];
  let three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  answers.forEach((v, i) => {

    if (one[i%(one.length)] === v) temp[0]++;
    if (two[i%(two.length)] === v) temp[1]++;
    if (three[i%(three.length)] === v) temp[2]++;
  });

  let max = 0;
  temp.forEach(v => {
    max = Math.max(max, v);
  });

  temp.forEach((v, i) => {
    if (v === max) answer.push(i + 1);
  })


  return answer;
}