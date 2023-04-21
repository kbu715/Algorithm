/**
 * @param {number[][]} grid
 * @return {number}
 */

// 섬의 둘레 구하기
var islandPerimeter = function (grid) {
  let count = 0;

  const isLeftWater = (r, c) => {
    if (c === 0) return true;
    return !grid[r][c - 1];
  };

  const isUpWater = (r, c) => {
    if (r === 0) return true;
    return !grid[r - 1][c];
  };

  const isRightWater = (r, c) => {
    if (c === grid[r].length - 1) return true;
    return !grid[r][c + 1];
  };

  const isDownWater = (r, c) => {
    if (r === grid.length - 1) return true;
    return !grid[r + 1][c];
  };

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j]) {
        // look left
        isLeftWater(i, j) && count++;
        // look up
        isUpWater(i, j) && count++;
        // look right
        isRightWater(i, j) && count++;
        // look down
        isDownWater(i, j) && count++;
      }
    }
  }
  return count;
};
