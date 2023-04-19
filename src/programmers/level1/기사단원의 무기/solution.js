function solution(number, limit, power) {
  let answer = 0;

  const knights = Array.from({ length: number }, (_, i) => i + 1).map((v) => {
    const divisorsLen = getDivisorsLength(v);
    if (divisorsLen > limit) {
      return power;
    } else {
      return divisorsLen;
    }
  });

  answer = knights.reduce((a, c) => a + c, 0);

  return answer;
}

function getDivisorsLength(num) {
  const divisors = [];

  for (let i = 1; i <= Math.sqrt(num); i++) {
    if (num % i === 0) {
      divisors.push(i);
      if (i !== num / i) {
        divisors.push(num / i);
      }
    }
  }

  return divisors.length;
}
