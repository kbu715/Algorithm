function solution(n, a, b) {
  let answer = 0;

  while (a !== b) {
    // 다음 번호가 같다면 a, b는 지금 둘이 붙은 상태
    a = getNext(a);
    b = getNext(b);
    answer++;
  }

  return answer;
}

function getNext(num) {
  return Math.floor((num + 1) / 2);
}

/*
function solution(n,a,b)
{
    let answer = 0;
    while(a !== b) {
        a = Math.ceil(a/2);
        b = Math.ceil(b/2);
        answer++;
    }

    return answer;
}
*/
