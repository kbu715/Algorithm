function solution(s) {
  var answer = [];

  const tuple = s
    .slice(1, -1)
    .split("},")
    .map((v) => v.replace("{", "").replace("}", ""))
    .sort((a, b) => a.length - b.length);

  const arr = tuple.map((v) => v.split(",").map((num) => +num));

  for (const one of arr) {
    for (const x of one) {
      if (!answer.includes(x)) {
        answer.push(x);
        break;
      }
    }
  }

  return answer;
}
