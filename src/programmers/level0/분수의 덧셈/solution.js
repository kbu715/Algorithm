function fnGCD(a, b) {
  return a % b ? fnGCD(b, a % b) : b;
}

function solution(denum1, num1, denum2, num2) {
  let denum = denum1 * num2 + denum2 * num1;
  let num = num1 * num2;
  let gcd = fnGCD(denum, num); //최대공약수

  return [denum / gcd, num / gcd];
}
/*
function solution(numer1, denom1, numer2, denom2) {
  const ja = denom1 * numer2 + denom2 * numer1; // 분자
  const mo = denom1 * denom2; // 분모

  let minNum; // 작은 수
  if (mo > ja) {
    minNum = ja;
  } else {
    minNum = mo;
  }

  while (mo % minNum !== 0 || ja % minNum !== 0) {
    minNum--;
  }
  return [ja / minNum, mo / minNum];
}

// 1. 통분
// 2. 분자분모의 최대공약수로 나눠줌

// 2-1. 분자분모 중 작은 수를 찾기
// 2-2. 작은수로 분자분모를 나눠보기
// 2-2-1. 둘다 나누어 떨어지면 그 나눈 수가 최대공약수
// 2-2-2. 안 나누어 떨어지면 작은 수를 1 줄이고 2-2로 돌아가기

*/
