function solution(board) {
  var answer = 0;
  let n = board.length;

  let dx = [0, 1, 1, 1, 0, -1, -1, -1];
  let dy = [-1, -1, 0, 1, 1, 1, 0, -1];

  for (let r = 0; r < n; r++) {
    for (let c = 0; c < n; c++) {
      if (board[r][c] === 1) {
        for (let d = 0; d < 8; d++) {
          let nr = r + dy[d];
          let nc = c + dx[d];

          if (nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] === 1) {
            continue;
          }
          board[nr][nc] = 2;
        }
      }
    }
  }

  answer = board
    .map((row) => row.filter((value) => value === 0).length)
    .reduce((a, c) => a + c, 0);

  return answer;
}
