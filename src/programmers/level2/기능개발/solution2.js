function solution(progresses, speeds) {
  let answer = [];

  while (progresses.length > 0) {
    // 하루 단위 개발
    for (let i in speeds) {
      if (progresses[i] < 100) {
        progresses[i] += speeds[i];
      }
    }

    // 배포
    let cnt = 0;
    while (progresses[0] >= 100) {
      progresses.shift();
      speeds.shift();
      cnt++;
    }
    if (cnt > 0) {
      answer.push(cnt);
    }
  }

  return answer;
}
