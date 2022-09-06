function solution(numbers, hand) {
  let answer = "";
  let lefthandCurrentPos = "*",
    righthandCurrentPos = "#";
  answer = numbers
    .map((number) => {
      if ([1, 4, 7].includes(number)) {
        lefthandCurrentPos = number;
        return "L";
      } else if ([3, 6, 9].includes(number)) {
        righthandCurrentPos = number;
        return "R";
      } else {
        const leftOrRight = getLeftOrRight(
          number,
          lefthandCurrentPos,
          righthandCurrentPos
        );
        if (leftOrRight === "R") {
          righthandCurrentPos = number;
        } else if (leftOrRight === "L") {
          lefthandCurrentPos = number;
        } else {
          if (hand === "right") righthandCurrentPos = number;
          else lefthandCurrentPos = number;
        }
        return leftOrRight;
      }
    })
    .map((v) => (v === "same" ? (hand === "right" ? "R" : "L") : v))
    .join("");

  return answer;
}

function getLeftOrRight(num, left, right) {
  const leftDiff =
    Math.abs(getCoord(num)[0] - getCoord(left)[0]) +
    Math.abs(getCoord(num)[1] - getCoord(left)[1]);
  const rightDiff =
    Math.abs(getCoord(num)[0] - getCoord(right)[0]) +
    Math.abs(getCoord(num)[1] - getCoord(right)[1]);

  if (leftDiff > rightDiff) {
    return "R";
  } else if (leftDiff < rightDiff) {
    return "L";
  } else {
    return "same";
  }
}

function getCoord(num) {
  let padNums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];

  if (num === "*") return [3, 0];
  else if (num === "#") return [3, 2];

  if (num === 0) return [3, 1];
  else {
    const r = Math.floor(padNums.findIndex((v) => v === num) / 3);
    const c = padNums.findIndex((v) => v === num) % 3;
    return [r, c]; // 행 열
  }
}
