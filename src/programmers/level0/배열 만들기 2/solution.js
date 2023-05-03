function solution(l, r) {
  let answer = [];
  const regex = /[0|5]/g;
  for (let i = l; i <= r; i++) {
    if (String(i).replace(regex, "") === "") {
      answer.push(i);
    }
  }
  return answer.length ? answer : [-1];
}
