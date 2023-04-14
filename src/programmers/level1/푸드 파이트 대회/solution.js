function solution(food) {
  let answer = "";
  let front = "";
  let rear = "";
  front = food
    .map((cal, idx) => String(idx).repeat(Math.floor(cal / 2)))
    .reduce((a, c) => a + c, "");
  rear = front.split("").reverse().join("");

  answer = front + "0" + rear;

  return answer;
}
