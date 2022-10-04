function solution(sides) {
  var answer = 0;

  let max = Math.max(...sides);
  const sum = sides[0] + sides[1];

  // sides중 긴 변이 가장 긴 변인 경우
  let i = max;

  while (i + sum - max > max && i >= Math.abs(sides[0] - sides[1])) {
    answer++;
    i--;
  }

  // 나머지 한 변이 가장 긴 변인 경우

  i = max + 1;
  while (sum > i) {
    answer++;
    i++;
  }

  return answer;
}
