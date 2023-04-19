function solution(s) {
  let str = s.toLowerCase();

  let pc = str.split("").filter((v) => v === "p").length;
  let yc = str.split("").filter((v) => v === "y").length;

  return pc === yc;
}
