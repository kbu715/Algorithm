function solution(arr) {
  var answer = [];

  const rows = arr.length;
  const cols = arr[0].length;

  const diff = Math.abs(rows - cols);

  if (rows === cols) return arr;
  else if (rows > cols) {
    const temp = new Array(diff).fill(0);
    answer = arr.map((v) => [...v].concat(temp));
  } else {
    answer = [...arr];
    for (let i = 0; i < diff; i++) {
      const temp = new Array(cols).fill(0);
      answer = [...answer, temp];
    }
  }
  return answer;
}
