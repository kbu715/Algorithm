function solution(arr) {
  let indexArr = [];

  arr.forEach((v, i) => {
    if (v === 2) indexArr.push(i);
  });

  const start = indexArr[0];
  const end = indexArr[indexArr.length - 1];

  if (!start && !end) return [-1];

  if (!end) return [2];
  else {
    return arr.slice(start, end + 1);
  }
}
