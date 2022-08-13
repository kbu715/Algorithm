function hide_numbers(phone_number) {
  var result = "*".repeat(phone_number.length - 4) + phone_number.slice(-4);
  //함수를 완성해주세요

  return result;
}
