function solution(brown, yellow) {
  let w, h;
  // 카펫의 최소 높이는 3
  for (h = 3; h <= (brown + yellow) / h; h++) {
    w = (brown + yellow) / h;
    // 각각 -2를 해준 이유는 : 중앙에 노란색이 있고, 테두리는 갈색이므로
    if ((w - 2) * (h - 2) === yellow) {
      break;
    }
  }

  return [w, h];
}
