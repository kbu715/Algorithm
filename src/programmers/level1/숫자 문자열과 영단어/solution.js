function solution(s) {
  let answer = s;

  const str = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];

  for (const x of str) {
    const index = str.findIndex((v) => v === x);
    while (answer.includes(x)) {
      answer = answer.replace(x, index);
    }
  }
  answer = +answer;

  return answer;
}
