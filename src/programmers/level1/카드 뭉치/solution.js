function solution(cards1, cards2, goal) {
  let answer = "Yes";
  for (const word of goal) {
    if (cards1[0] === word) {
      cards1.shift();
    } else if (cards2[0] === word) {
      cards2.shift();
    } else {
      answer = "No";
      break;
    }
  }

  return answer;
}
