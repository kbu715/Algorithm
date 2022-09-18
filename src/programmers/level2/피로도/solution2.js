function solution(k, dungeons) {
  const N = dungeons.length;
  const visited = new Array(N).fill(false);
  let answer = 0;

  function DFS(k, cnt) {
    answer = Math.max(cnt, answer);

    for (let j = 0; j < N; j++) {
      if (k >= dungeons[j][0] && !visited[j]) {
        visited[j] = true;
        DFS(k - dungeons[j][1], cnt + 1);
        visited[j] = false;
      }
    }
  }

  DFS(k, 0);
  return answer;
}
