function solution(a, b) {
  let GCD = getGCD(a, b); // 최대공약수

  let bunmo = b / GCD; // 분자와 분모의 최대공약수로 약분하면 기약분수를 만들 수 있습니다.

  while (bunmo >= 1) {
    if (bunmo % 2 === 0) {
      bunmo /= 2;
    } else if (bunmo % 5 === 0) {
      bunmo /= 5;
    } else {
      break;
    }
  }

  return bunmo === 1 ? 1 : 2;
}

// 유클리드 호제법
function getGCD(a, b) {
  let r;
  while (b != 0) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
