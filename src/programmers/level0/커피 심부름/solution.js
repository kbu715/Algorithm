function solution(order) {
  return order.reduce((a, c) => a + getPrice(c), 0);
}
function getPrice(menuName) {
  switch (menuName) {
    case "iceamericano":
    case "americanoice":
    case "hotamericano":
    case "americanohot":
    case "americano":
    case "anything":
      return 4500;

    case "icecafelatte":
    case "cafelatteice":
    case "hotcafelatte":
    case "cafelattehot":
    case "cafelatte":
      return 5000;
    default:
      break;
  }
}
