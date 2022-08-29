function solution(land) {
  var answer = 0;

  return Math.max(
    ...land.reduce(
      (a, c) => {
        // a: acc, c: current
        // a: 누적 배열(dp) c: 현재 행
        return [
          c[0] + Math.max(a[1], a[2], a[3]), // 0번째 값 제외 이전 행의 최댓값 + 현재 행 0번째 값
          c[1] + Math.max(a[0], a[2], a[3]),
          c[2] + Math.max(a[0], a[1], a[3]),
          c[3] + Math.max(a[0], a[1], a[2]),
        ];
      },
      [0, 0, 0, 0]
    )
  );
}
