function solution(s) {
  
  let answer = "";

  answer = s.split('').sort((a, b) => {
    return b.charCodeAt(0) - a.charCodeAt(0);
  }).join('');




  return answer;
}