function solution(lottos, win_nums) {
  const left_nums_length = win_nums.filter(
    (num) => !lottos.includes(num)
  ).length;
  const unknown_nums_length = lottos.filter((v) => v === 0).length;

  return [
    getRank(left_nums_length - unknown_nums_length),
    getRank(left_nums_length),
  ];
}

function getRank(left) {
  switch (left) {
    case 0:
      return 1;
    case 1:
      return 2;
    case 2:
      return 3;
    case 3:
      return 4;
    case 4:
      return 5;
    case 5:
    case 6:
      return 6;
  }
}
