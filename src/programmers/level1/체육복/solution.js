function solution(n, lost, reserve) {
  let answer = 0;
  let arr = Array.from(Array(n + 1)).fill(0); // 학생들의 체육복 개수 1번 학생부터 n번 학생까지
  
  for (let i = 1; i <= n; i++){
    arr[i] = 1;
    if (reserve.includes(i)) {
      arr[i]++;
    } 
    if(lost.includes(i)){
      arr[i]--;
    }       
  }

  for(let i = 1 ; i <= n ; i++){
     if(arr[i] === 0) { 
         if (arr[i - 1] === 2) {  
           arr[i]++;
           arr[i - 1]--; 
         } else if (arr[i + 1] === 2) { 
           arr[i]++;
           arr[i + 1]--;
         }
     }
  }

  answer = arr.filter(v => v >= 1).length;
  
  return answer;
}