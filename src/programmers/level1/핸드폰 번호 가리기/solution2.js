function solution(phone_number) {
  let answer = "";

  let n = phone_number.length;

  answer = phone_number
    .split("")
    .map((x, i) => {
      if (i < n - 4) {
        return "*";
      } else return x;
    })
    .join("");

  return answer;
}
