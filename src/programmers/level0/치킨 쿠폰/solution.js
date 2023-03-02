// function solution(chicken) {
//   // 최대 서버스 치킨의 수

//   let service = 0; // 서비스 치킨의 수
//   let coupons = chicken; // 쿠폰의 수

//   while (coupons >= 10) {
//     let chickens = Math.floor(coupons / 10); // 쿠폰 10개로 시킨 서비스 치킨의 수
//     service += chickens; // 서비스 치킨 누적시키기
//     coupons = coupons - chickens * 10; // 쿠폰 감소 시키기
//     coupons += chickens; // 서비스 치킨 수 만큼 쿠폰 증가
//   }

//   return service;
// }

function solution(chicken) {
  let answer = 0;
  let coupon = chicken;

  while (coupon >= 10) {
    answer = answer + parseInt(coupon / 10);
    coupon = parseInt(coupon / 10) + (coupon % 10);
  }

  return answer;
}
