function solution(t, p) {
  let count = 0;
  for (let i = 0; i <= t.length - p.length; i++) {
    let value = t.slice(i, i + p.length);
    if (+p >= +value) count++;
  }
  return count;
}

// first try

// function solution(t, p) {
//   let answer = 0;
//   let partial = [];

//   for (let i = 0, cnt = 0; i < t.length - p.length + 1; i++) {
//     if (cnt === p.length) {
//       cnt = 0;
//     }

//     let str = "";
//     while (cnt < p.length) {
//       str += t[i + cnt++];
//     }

//     partial = [...partial, str];
//   }

//   answer = partial.filter((v) => Number(p) >= Number(v)).length;

//   return answer;
// }
