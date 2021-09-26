function solution(s) {
  var answer = '';
  
  let words = s.split(' ');

  words.forEach((word, idx) => {
    let str = word.split('').map((v, i) => i % 2 === 0 ? v.toUpperCase() : v.toLowerCase()).join('');
    if (idx === words.length - 1) {
      answer += str;
    } else {
      answer += str + " ";
    }
  })
  
  return answer;
}
