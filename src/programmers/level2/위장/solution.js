function solution(clothes) {
  let answer = 0;

  let obj = new Object();
  for (const cloth of clothes) {
    if (!obj.hasOwnProperty(cloth[1])) obj[cloth[1]] = 1;
    else obj[cloth[1]] = obj[cloth[1]] + 1;
  }

  console.log(obj); // { headgear: 2, eyewear: 1 }

  answer =
    Object.values(obj)
      .map((n) => comb(n, 0) + comb(n, 1))
      .reduce((a, c) => a * c) - 1; // -1을 해주는 이유는 적어도 1개의 의상은 입어야 하기 때문입니다.

  return answer;
}

function comb(n, r) {
  if (n === r || r === 0) return 1;
  else {
    return comb(n - 1, r) + comb(n - 1, r - 1);
  }
}
