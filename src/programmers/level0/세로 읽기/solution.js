function solution(my_string, m, c) {
  const twoArray = [];

  for (let i = 0; i < my_string.length; i += m) {
    const temp = [];
    for (let j = 0; j < m; j++) {
      temp.push(my_string[i + j]);
    }
    twoArray.push(temp);
  }
  return twoArray.map((arr) => arr[c - 1]).join("");
}
