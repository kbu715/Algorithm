function solution(n) {
  var pizza = 1;

  while ((6 * pizza) % n !== 0) {
    pizza++;
  }

  return pizza;
}
