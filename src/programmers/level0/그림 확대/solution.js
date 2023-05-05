function solution(picture, k) {
  var answer = [];

  picture
    .map((line) =>
      line
        .split("")
        .map((c) => c.repeat(k))
        .join("")
    )
    .map((line) => new Array(k).fill(line))
    .forEach((lines) => {
      for (const line of lines) {
        answer.push(line);
      }
    });
  return answer;
}
