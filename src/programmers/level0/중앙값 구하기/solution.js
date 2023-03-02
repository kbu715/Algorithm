function solution(array) {
  var answer = 0;
  var len = array.length;
  array.sort((a, b) => a - b);
  answer = array[Math.floor(len / 2)];

  return answer;
}
