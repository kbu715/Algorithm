// LCM = (A * B) / GCD

// reduce
// 초기값을 제공하지 않으면 배열의 첫 번째 요소를 사용합니다.
function solution(arr) {
  return arr.reduce((a, b) => (a * b) / gcd(a, b));
}

function gcd(a, b) {
  return a % b ? gcd(b, a % b) : b;
}
