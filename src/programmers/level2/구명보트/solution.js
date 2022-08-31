//greedy
// 가장 무거운 사람과 가장 가벼운 사람이 한계 이하이면 둘다 태우고
// 한계 이상이면 무거운 사람만 태우기

function solution(people, limit) {
  // 보트 카운트
  let answer = 0;
  let startIndex = 0;
  let endIndex = people.length - 1;

  people.sort((a, b) => a - b);
  // 사람들이 구명보트에 다 탈때까지 실행
  while (startIndex <= endIndex) {
    if (startIndex === endIndex) {
      endIndex = -1;
    }
    // 현재 가장 가벼운 사람과 가장 무거운 사람이 보트 한계 이하이면 보트에 태우기
    if (people[startIndex] + people[endIndex] <= limit) {
      startIndex += 1;
      endIndex -= 1;
    } else {
      // 아니라면 무거운 사람만 태우기
      endIndex -= 1;
    }
    answer += 1;
  }
  return answer;
}
