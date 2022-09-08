function solution(n, words) {
  let idx;
  for (let i = 0; i < words.length; i++) {
    // 끝말잇기 틀린 경우
    if (i !== 0 && words[i][0] !== words[i - 1][words[i - 1].length - 1]) {
      idx = i + 1;
      return [idx % n === 0 ? n : idx % n, Math.ceil(idx / n)];
    }
    // 중복 단어 말한 경우
    for (let j = i - 1; j >= 0; j--) {
      if (words[i] === words[j]) {
        idx = i + 1;
        return [idx % n === 0 ? n : idx % n, Math.ceil(idx / n)];
      }
    }
  }
  return [0, 0];
}
