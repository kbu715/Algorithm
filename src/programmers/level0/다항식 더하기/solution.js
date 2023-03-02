// function solution(polynomial) {
//   let answer = "";

//   const arr = polynomial.split(" ").filter((v) => v !== "+");

//   let xArr = []; // x계수의 배열
//   let nArr = []; // 자연수의 배열

//   for (const item of arr) {
//     if (item.indexOf("x") >= 0) {
//       xArr.push(Number(item.replace("x", "")));
//     } else {
//       nArr.push(Number(item));
//     }
//   }

//   xArr = xArr.map((v) => (v === 0 ? 1 : v));

//   let xSum = xArr.reduce((a, c) => a + c, 0); // x계수 총합
//   let nSum = nArr.reduce((a, c) => a + c, 0); // 자연수 총합

//   answer =
//     (xSum === 0 ? "" : xSum === 1 ? "x" : xSum + "x") +
//     (nSum === 0 ? "" : xSum === 0 ? nSum : " + " + nSum);

//   return answer;
// }

function solution(polynomial) {
  const arr = polynomial.split(" + ");
  const xNum = arr
    .filter((n) => n.includes("x"))
    .map((n) => n.replace("x", "") || "1")
    .reduce((acc, cur) => acc + parseInt(cur, 10), 0);
  const num = arr
    .filter((n) => !isNaN(n))
    .reduce((acc, cur) => acc + parseInt(cur, 10), 0);

  let answer = [];
  if (xNum) answer.push(`${xNum === 1 ? "" : xNum}x`);
  if (num) answer.push(num);

  return answer.join(" + ");
}
