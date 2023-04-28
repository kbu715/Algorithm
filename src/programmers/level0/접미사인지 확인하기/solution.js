function solution(my_string, is_suffix) {
  const suffixLength = is_suffix.length;
  const myStringLength = my_string.length;
  return my_string.substring(myStringLength - suffixLength) === is_suffix
    ? 1
    : 0;
}
