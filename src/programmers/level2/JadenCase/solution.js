function solution(s) {
  return s
    .toLowerCase()
    .split(" ")
    .map((v) => `${v.charAt(0).toUpperCase()}${v.substring(1)}`)
    .join(" ");
}

// v.charAt(0) -> O
// v[0] -> 런타임에러 X
// 참고 : https://thisthat.dev/string-char-at-vs-string-bracket-notation/
