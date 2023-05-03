function solution(str_list) {
  const lIndex = str_list.findIndex((v) => v === "l");
  const rIndex = str_list.findIndex((v) => v === "r");

  if (lIndex >= 0 && rIndex >= 0) {
    if (lIndex < rIndex) {
      return str_list.slice(0, lIndex);
    } else {
      return str_list.slice(rIndex + 1);
    }
  } else if (lIndex >= 0 && rIndex < 0) {
    return str_list.slice(0, lIndex);
  } else if (rIndex >= 0 && lIndex < 0) {
    return str_list.slice(rIndex + 1);
  } else {
    return [];
  }
}
