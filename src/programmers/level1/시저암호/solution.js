function solution(s, n) {
  const ASCIICODE = {
      A : 'A'.charCodeAt(), // 65
      Z : 'Z'.charCodeAt(), // 90
      a : 'a'.charCodeAt(), // 97
      z : 'z'.charCodeAt(), // 122
      gap : 'Z'.charCodeAt() - 'A'.charCodeAt(), // 25
  }
  let answer = '';
  let charCode = '';
  
  for(let i = 0; i < s.length; ++i){
      if(s[i] === ' '){
          answer += s[i];
          continue;
      }
      charCode = s.charCodeAt(i);
 
      if(ASCIICODE.A <= charCode && charCode <= ASCIICODE.Z){
          charCode += n;
          if(ASCIICODE.Z < charCode){
              charCode -= (ASCIICODE.gap + 1);
          } 
      } else if(ASCIICODE.a <= charCode && charCode <= ASCIICODE.z){
          charCode += n;
          if(ASCIICODE.z < charCode){
              charCode -= (ASCIICODE.gap + 1);
          }
      }
    
      answer += String.fromCharCode(charCode);
  }
  
  return answer;
}