function solution(i, j, k) {
  let str = "";

  for (let a = i; a <= j; a++) {
    str += a.toString();
  }

  return str.split("").filter((v) => k === Number(v)).length;
}
