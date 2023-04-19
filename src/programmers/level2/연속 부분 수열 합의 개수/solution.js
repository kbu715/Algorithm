// function solution(elements) {
//   let answer = 0;

//   //길이 1 + 길이 elements.length인 경우
//   answer += new Set(elements).size + 1;
//   let temp = [];
//   for (let len = 2; len <= elements.length - 1; len++) {
//     let queue = elements;

//     let i = 0,
//       j = 0,
//       sum = 0;

//     while (j < elements.length) {
//       while (i < len) {
//         const first = queue.shift();
//         queue.push(first);
//         sum += first;
//         i++;
//       }
//       temp.push(sum);
//       j++;
//       i = 0;
//       sum = 0;
//     }
//   }

//   answer += new Set(temp).size;

//   return answer;
// }

// Time over TT

function solution(elements) {
  const set = new Set();

  for (let i = 1; i <= elements.length; i++) {
    // 원순열 만들기 - i개의 원소를 뒤에 추가해준다
    // i = 1, 뒤에 추가 slice(0, 1)
    // i = 2, 뒤에 추가 slice(0, 2)
    // i = 3, 뒤에 추가 slice(0, 3)
    // i = 4, 뒤에 추가 slice(0, 4)
    // i = 5, 뒤에 추가 slice(0, 5)

    // Circular Sequence
    const cSeq = [...elements, ...elements.slice(0, i)];

    for (let j = 0; j < elements.length; j++) {
      set.add(cSeq.slice(j, j + i).reduce((a, c) => a + c, 0));
    }
  }
  return set.size;
}
