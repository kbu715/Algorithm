function solution(n, m, section) {
  let answer = 0;
  let current = 0; // 0번째 벽 (가상의 벽)을 가리키고 있다고 치자

  // Greedy
  for (const x of section) {
    if (x > current) {
      answer++;
      current = x + m - 1; // m만큼 칠했다고 생각하고 어딜 가리키는지만 생각하기
    }
  }

  return answer;
}
