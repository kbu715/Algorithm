function solution(my_string, m, c) {
  let answer = "";

  let doubleArray = [];
  let str = "";
  for (let c of my_string) {
    str += c;
    if (str.length == m) {
      doubleArray.push(str);
      str = "";
    }
  }

  doubleArray.forEach((arr) => {
    answer += arr[c - 1];
  });

  return answer;
}
