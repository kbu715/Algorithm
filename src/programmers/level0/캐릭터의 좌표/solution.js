// function solution(keyinput, board) {
//   const [xLimit, yLimit] = [Math.floor(board[0] / 2), Math.floor(board[1] / 2)];

//   function getCoords(key, coords) {
//     const [x, y] = coords;

//     switch (key) {
//       case "left":
//         if (x - 1 < -xLimit) {
//           return [x, y];
//         }
//         return [x - 1, y];
//       case "right":
//         if (x + 1 > xLimit) {
//           return [x, y];
//         }
//         return [x + 1, y];
//       case "up":
//         if (y + 1 > yLimit) {
//           return [x, y];
//         }
//         return [x, y + 1];
//       case "down":
//         if (y - 1 < -yLimit) {
//           return [x, y];
//         }
//         return [x, y - 1];
//     }
//   }
//   let answer = [0, 0];
//   for (const d of keyinput) {
//     answer = getCoords(d, answer);
//   }
//   return answer;
// }

function solution(keyinput, board) {
  let coords = [0, 0];
  const [xLimit, yLimit] = board.map((v) => v / 2);
  for (let p of keyinput) {
    switch (p) {
      case "left":
        if (-coords[0] < xLimit - 1) coords[0]--;
        break;
      case "right":
        if (coords[0] < xLimit - 1) coords[0]++;
        break;
      case "up":
        if (coords[1] < yLimit - 1) coords[1]++;
        break;
      case "down":
        if (-coords[1] < yLimit - 1) coords[1]--;
        break;
    }
  }
  return coords;
}
