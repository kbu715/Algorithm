function solution(sizes) {
  let w = 0;
  let h = 0;
  sizes.forEach((s) => {
    const [a, b] = s.sort((a, b) => a - b); // 세로가 길게?
    if (a > h) h = a;
    if (b > w) w = b;
  });

  return w * h;
}
