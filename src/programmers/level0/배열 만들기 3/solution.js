function solution(arr, intervals) {
  let answer = [];
  intervals.forEach((i) => {
    answer = [...answer, ...arr.slice(i[0], i[1] + 1)];
  });
  return answer;
}
