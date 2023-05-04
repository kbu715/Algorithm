function solution(arr) {
  let prev = [...arr];
  let count = 0;

  while (true) {
    const after = prev.map((v) => {
      if (v >= 50 && v % 2 === 0) return v / 2;
      else if (v < 50 && v % 2 !== 0) return v * 2 + 1;
      else return v;
    });
    console.log(prev, after);
    if (isSame(prev, after)) {
      break;
    }
    prev = [...after];
    count++;
  }
  return count;
}

function isSame(arr1, arr2) {
  for (let i = 0; i < arr1.length; i++) {
    if (arr1[i] !== arr2[i]) return false;
  }
  return true;
}
