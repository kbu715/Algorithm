function solution(answers) {
  let answer = [];
  // patterns
  let soopoja1 = [1, 2, 3, 4, 5];
  let soopoja2 = [2, 1, 2, 3, 2, 4, 2, 5];
  let soopoja3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

  let s1Count = 0,
    s2Count = 0,
    s3Count = 0;

  for (let i = 0; i < answers.length; i++) {
    let s1 = i % soopoja1.length;
    let s2 = i % soopoja2.length;
    let s3 = i % soopoja3.length;

    if (answers[i] === soopoja1[s1]) s1Count++;
    if (answers[i] === soopoja2[s2]) s2Count++;
    if (answers[i] === soopoja3[s3]) s3Count++;
  }
  let max = Math.max(s1Count, s2Count, s3Count);
  if (max === s1Count) answer.push(1);
  if (max === s2Count) answer.push(2);
  if (max === s3Count) answer.push(3);

  return answer;
}
