function naiveSearch(long, short) {
  let answer = 0;
  for (let i = 0; i < long.length; i++) {
    let cnt = 0;
    for (let j = 0; j < short.length; j++) {
      if (long[i + j] === short[j]) {
        cnt++;
        continue;
      } else {
        break;
      }
    }
    if (cnt === short.length) {
      answer++;
    }
  }
  return answer;
}

const result = naiveSearch("lorie loled", "l");
console.log(result);
