function solution(N, stages) {
  var answer = [];

  answer = Array.from({ length: N }, () => 0)
    .map(
      (v, i) =>
        stages.filter((stage) => stage === i + 1).length /
        stages.filter((stage) => stage > i + 1).length
    )
    .map((rate, index) => [rate, index + 1])
    .sort((a, b) => b[0] - a[0])
    .map((value) => value[1]);

  return answer;
}
