function solution(numbers) {

  let answer = [];
  let selected = Array.from({ length: 2 }, () => 0);
  let set = new Set();

  function comb(cnt, start) {
  
    if (cnt === 2) {
      let result = selected.reduce((acc, cur) => acc + cur, 0);
      set.add(result);
      return;
    }
    
    for (let i = start; i < numbers.length; i++) {
      
      selected[cnt] = numbers[i];
      comb(cnt + 1, i+1);
      
    }
  
  }
  
  comb(0, 0);

  answer = Array.from(set).sort((a, b) => a - b);



  return answer;
}



