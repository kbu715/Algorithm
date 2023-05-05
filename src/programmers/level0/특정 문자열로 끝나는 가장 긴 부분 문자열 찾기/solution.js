function solution(myString, pat) {
  let answer = "";
  let i = 0;
  while (i <= myString.length) {
    const subStr = myString.substring(0, i);
    if (subStr.endsWith(pat)) {
      answer = subStr;
    }
    i++;
  }
  return answer;
}
