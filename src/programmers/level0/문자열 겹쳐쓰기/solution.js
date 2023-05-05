function solution(my_string, overwrite_string, s) {
  let answer = "";
  const len = overwrite_string.length;

  answer =
    my_string.substring(0, s) + overwrite_string + my_string.substring(s + len);
  return answer;
}
