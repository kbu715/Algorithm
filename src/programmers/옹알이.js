function solution(babbling) {
  let answer = 0;
  let n = babbling.length;
  let pronunciation = ["aya", "ye", "woo", "ma"];

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < pronunciation.length; j++) {
      if (babbling[i].includes(pronunciation[j])) {
        let index = babbling[i].indexOf(pronunciation[j]);
        let prev = index;
        let post;
        while (index >= 0) {
          babbling[i] = babbling[i].replace(pronunciation[j], "");
          index = babbling[i].indexOf(pronunciation[j]);
          post = index;
          // 연속되는 값이 있는 경우 예를들어 'yeye'
          // prev와 post에 들어있는 index 값이 같다
          if (prev === post) {
            break;
          }
        }
      }
    }
  }

  console.log(babbling);

  answer = babbling.filter((item) => item === "").length;

  return answer;
}

// function solution(babbling) {
//   let df = ["aya", "ye", "woo", "ma"];
//   let res = 0;
//   for (let w of babbling) {
//     // ["aya", "yee", "u", "maa"]
//     if (df.some((f) => w.includes(f + f))) continue;

//     let rest = df.reduce((a, f) => a.replaceAll(f, ""), w);

//     if (rest.length > 0) continue;

//     res++;
//   }

//   return res;
// }
