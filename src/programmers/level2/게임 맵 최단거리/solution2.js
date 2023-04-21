function solution(maps) {
  let n = maps.length - 1;
  let m = maps[0].length - 1;

  let queue = [[0, 0]];

  let visited = Array.from(new Array(maps.length), () =>
    new Array(maps[0].length).fill(false)
  );

  let count = 0;

  while (queue.length) {
    count++;
    for (let i = 0; i < queue.length; i++) {
      let [curY, curX] = queue.shift();

      if (visited[curY][curX]) continue;

      maps[curY][curX] = 0;

      visited[curY][curX] = true;

      if (curY === n && curX === m) return count;

      if (curY < n && maps[curY + 1][curX] === 1) queue.push([curY + 1, curX]);
      if (curX < m && maps[curY][curX + 1] === 1) queue.push([curY, curX + 1]);
      if (curY > 0 && maps[curY - 1][curX] === 1) queue.push([curY - 1, curX]);
      if (curX > 0 && maps[curY][curX - 1] === 1) queue.push([curY, curX - 1]);
    }
  }

  return -1;
}
