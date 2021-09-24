function solution(arr) {
  
  let answer = [];
  let temp = arr.slice();
  temp.sort((a, b) => a - b);

  let num = temp.shift();

  answer = arr.filter((v, i) => v !== num);
  
  if (answer.length === 0) {
    answer = [-1];
  }


  return answer;
}