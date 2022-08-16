function solution(sizes) {
  let answer = 0;

  let n = sizes.length;

  // 모든 명함이 가로가 길고 세로가 짧게 재배열 한다. // 비교하기 쉽게
  for (let i = 0; i < n; i++) {
    if (sizes[i][0] < sizes[i][1])
      [sizes[i][0], sizes[i][1]] = [sizes[i][1], sizes[i][0]]; // 최신문법
  }

  let maxW = Math.max(...sizes.map((v) => v[0]));
  let maxH = Math.max(...sizes.map((v) => v[1]));

  answer = maxW * maxH;

  return answer;
}
