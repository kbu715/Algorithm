/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function (word1, word2) {
  let answer = "";
  let i = 0;
  while (true) {
    if (!word1[i] && !word2[i]) {
      break;
    }
    if (word1[i]) {
      answer += word1[i];
    }

    if (word2[i]) {
      answer += word2[i];
    }
    i++;
  }
  return answer;
};
