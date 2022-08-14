function solution(strings, n) {
  var answer = [];

  strings.sort().sort((a, b) => a[n].charCodeAt(0) - b[n].charCodeAt(0));

  answer = strings;

  return answer;
}
