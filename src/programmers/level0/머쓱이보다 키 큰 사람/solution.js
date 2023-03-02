function solution(array, height) {
  let answer = 0;

  array.sort((a, b) => b - a);

  for (let i = 0; i < array.length; i++) {
    if (height >= array[i]) {
      return i;
    }
  }
  return array.length;
}
