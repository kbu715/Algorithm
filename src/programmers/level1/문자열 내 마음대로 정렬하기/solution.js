function solution(strings, n) {
  let answer = [];

  strings.sort((a, b) => {
    if (a.charAt(n) > b.charAt(n)) {
      return 1;
    } else if (a.charAt(n) < b.charAt(n)) {
      return -1;
    } else {
      return a > b ? 1 : -1;
    }
  });

  answer = strings;

  return answer;
}