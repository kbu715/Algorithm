function solution(maps) {
  const n = maps.length;
  const m = maps[0].length;
  const visited = Array.from(new Array(maps.length), () =>
    new Array(maps[0].length).fill(false)
  );

  // visited 만들기
  for (let i = 0; i < n; i++)
    for (let j = 0; j < m; j++)
      if (maps[i][j] === 1) visited[i][j] = false;
      else if (maps[i][j] === 0) visited[i][j] = true; // 못 지나감

  const queue = [[0, 0, 1]]; // (y, x, count)

  while (queue.length) {
    let [y, x, count] = queue.shift();

    // y, x가 n-1, m-1에 도착하면 return
    if (y === n - 1 && x === m - 1) {
      return count;
    }

    if (y < 0 || x < 0 || y > n - 1 || x > m - 1) continue;

    // 상
    if (y - 1 >= 0 && visited[y - 1][x] === false) {
      queue.push([y - 1, x, count + 1]);
      visited[y - 1][x] = true;
    }
    // 하
    if (y + 1 <= n - 1 && visited[y + 1][x] === false) {
      queue.push([y + 1, x, count + 1]);
      visited[y + 1][x] = true;
    }
    // 좌
    if (x - 1 >= 0 && visited[y][x - 1] === false) {
      queue.push([y, x - 1, count + 1]);
      visited[y][x - 1] = true;
    }
    // 우
    if (x + 1 <= m - 1 && visited[y][x + 1] === false) {
      queue.push([y, x + 1, count + 1]);
      visited[y][x + 1] = true;
    }
  }
  return -1;
}
