function solution(n, left, right) {
  let answer = [];
  // (r, c) 에 해당하는 값은 Math.max(r, c) + 1 <- 이 규칙을 찾으면 해결 가능해진다.
  for (let i = left; i <= right; i++) {
    answer.push(Math.max(Math.floor(i / n), i % n) + 1);
  }

  return answer;
}

// function solution(n, left, right) {
//   let answer = [];

//   for (let i = 0; i < n; i++) {
//     for (let j = 0; j < n; j++) {
//       const idx = n * i + j;
//       if (idx < left || idx > right) continue;
//       if (j <= i) {
//         answer.push(i + 1);
//       } else {
//         answer.push(j + 1);
//       }
//     }
//   }

//   return answer;
// }

// 자꾸 시간 초과...
// 직접 left ~ right에 해당하는 값을 찾아야 할듯함
