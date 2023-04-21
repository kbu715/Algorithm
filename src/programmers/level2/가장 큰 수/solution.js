// 1. ab ba 비교
function solution(numbers) {
  let answer = numbers.map((num) => num.toString());

  answer.sort(function (a, b) {
    return b + a - (a + b);
  });

  return answer.join("")[0] == "0" ? "0" : answer.join("");
}
