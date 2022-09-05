function solution(progresses, speeds) {
  let answer = [0];
  // 배포하는데 까지 걸리는 일 수
  let days = progresses.map((progress, index) =>
    Math.ceil((100 - progress) / speeds[index])
  );
  let maxDay = days[0];

  for (let i = 0, cnt = 0; i < days.length; i++) {
    if (maxDay >= days[i]) {
      answer[cnt] += 1;
    } else {
      maxDay = days[i];
      answer[++cnt] = 1;
    }
  }

  return answer;
}
