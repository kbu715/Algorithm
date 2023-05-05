function solution(p) {
  let answer = 0;

  for (let i = 0; i < p.length; i++) {
    for (let j = i + 1; j < p.length; j++) {
      if (p[i][0] === p[j][1] && p[i][1] === p[j][0]) answer++;
    }
  }

  return answer;
}
