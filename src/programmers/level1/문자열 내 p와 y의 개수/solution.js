function solution(s){
  let answer = true;

  let pCnt = 0, yCnt = 0;
  s.split('').forEach(v => {
    if (v.toLowerCase() === 'p') {
      pCnt++;
    } else if (v.toLowerCase() === 'y') {
      yCnt++;
    }
  })
  if (pCnt !== yCnt) {
    answer = false;
  }

  return answer;
}