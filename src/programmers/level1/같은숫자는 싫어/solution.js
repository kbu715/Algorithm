function solution(arr)
{
    let answer = [];

    let temp = [];
  
  for (let i = 0; i < arr.length - 1; i++) {
    if (arr[i] === arr[i + 1]) {
      continue;
    }
    temp.push(arr[i]);
  }
  temp.push(arr[arr.length - 1]);
  
  answer = temp;
    return answer;
}