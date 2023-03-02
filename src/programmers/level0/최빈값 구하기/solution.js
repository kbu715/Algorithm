function solution(array) {
  let mostFrequentValue = -1; // 최빈값
  let mostFrequentRepeat = 0; // 최빈값이 될 때 몇번 반복해서 됐는지
  let repeat = 0; // 현재 몇번 반복했는지
  let beforeNumber = -1; // 현재 숫자의 이전 숫자
  let isDuplicated = false;

  array.sort((a, b) => a - b);

  // 예시
  // 1 | 2 | 3 3 3 | 4

  for (let i = 0; i < array.length; i++) {
    if (beforeNumber !== array[i]) {
      repeat = 1;
    } else {
      repeat += 1;
    }

    if (repeat === mostFrequentRepeat) {
      if (mostFrequentValue !== array[i]) {
        isDuplicated = true;
      }
    }
    if (repeat > mostFrequentRepeat) {
      mostFrequentValue = array[i];
      mostFrequentRepeat = repeat;
      isDuplicated = false;
    }
    beforeNumber = array[i];
  }

  if (isDuplicated) return -1;
  return mostFrequentValue;
}
