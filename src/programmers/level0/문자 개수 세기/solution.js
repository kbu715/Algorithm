function solution(my_string) {
  let answer = Array.from({ length: 52 }).fill(0);
  let lookup = {};
  my_string.split("").forEach((c) => {
    lookup[c] = lookup[c] ? lookup[c] + 1 : 1;
  });

  Object.entries(lookup).forEach(([key, value]) => {
    const code = key.charCodeAt(0);

    if (code >= 65 && code <= 90) {
      answer[code - 65] = value;
    } else if (code >= 97 && code <= 122) {
      answer[code - 97 + 25 + 1] = value;
    }
  });

  return answer;

  // console.log(String.fromCharCode(65)) // A
  // console.log(String.fromCharCode(90)) // Z
  // console.log(String.fromCharCode(97)) // a
  // console.log(String.fromCharCode(122)) // z
}
