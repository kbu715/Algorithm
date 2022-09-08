function solution(arr) {
  // n개의 최소 공배수 구하기
  while (arr.length > 1) {
    const a = arr.pop();
    const b = arr.pop();
    arr.push(lcm(a, b));
  }

  return arr[0];
}
function lcm(a, b) {
  // 유클리드 호제법 이용 최소공배수(lcm) 구하기
  const gcd = (a, b) => (a % b === 0 ? b : gcd(b, a % b));

  return (a * b) / gcd(a, b);
}
