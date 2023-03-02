// function solution(lines) {
//   let arr = Array.from({ length: 200 }, () => 0);

//   for (let line = 0; line < lines.length; line++) {
//     const start = lines[line][0];
//     const end = lines[line][1];

//     for (let i = start; i <= end - 1; i++) {
//       arr[i + 100] += 1;
//     }
//   }

//   return arr.filter((v) => v >= 2).length;
// }

function solution(lines) {
  let lineArr = new Array(200).fill(0);

  lines.forEach(([start, end]) => {
    for (; start < end; start++) lineArr[start + 100]++;
  });

  //   return lineArr.reduce((a, c) => (c > 1 ? a + 1 : a), 0);
  return lineArr.filter((v) => v > 1).length;
}
