function solution(n) {
  if (n == 1) return 1;

  var battery = 0;
  // n을 2로 나눠가며 나오는 나머지의 합
  while (n > 0) {
    battery += n % 2;
    n = Math.floor(n / 2);
  }

  return battery;
}
