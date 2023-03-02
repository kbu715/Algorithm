function solution(s) {
  let answer = "";
  const mySet = new Set(s);

  for (const x of mySet) {
    if (s.indexOf(x) === s.lastIndexOf(x)) {
      answer += x;
    }
  }

  answer = answer.split("").sort().join("");

  return answer;
}
