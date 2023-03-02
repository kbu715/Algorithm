function solution(num_list, n) {
  let answer = [];

  for (let i = 0, cnt = 0; i < num_list.length; i = i + n) {
    let tempArr = [];
    while (cnt < n) {
      tempArr.push(num_list[i + cnt]);
      cnt++;
    }
    answer.push(tempArr);
    tempArr = [];
    cnt = 0;
  }

  return answer;
}
