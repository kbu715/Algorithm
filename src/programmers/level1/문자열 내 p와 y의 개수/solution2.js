function solution(s) {
  var answer = true;

  let pc = 0,
    yc = 0;

  let sentence = s.toLowerCase();
  // console.log(sentence)

  for (const x of sentence) {
    if (x === "p") pc++;
    else if (x === "y") yc++;
  }

  answer = pc === yc;

  return answer;
}
