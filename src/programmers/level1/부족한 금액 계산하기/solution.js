function solution(price, money, count) {
  let answer = -1;
  let cost = 0;
  let diff = price;

  while (count > 0) {
    cost += diff;
    diff += price;
    count--;
  }
  if (cost < money) {
    return 0;
  }
  answer = Math.abs(cost - money);

  return answer;
}