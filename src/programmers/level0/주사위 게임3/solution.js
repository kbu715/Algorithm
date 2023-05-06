function solution(a, b, c, d) {
  const temp = [a, b, c, d];
  const lookup = {};
  temp.forEach((v) => {
    lookup[v] = (lookup[v] || 0) + 1;
  });

  // case 1 : 네 주사위에서 나온 숫자가 모두 p로 같다면
  if (a === b && b === c && c === d && d === a) {
    console.log("case 1");
    return 1111 * a;
  }

  // case 2 : 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q (p !== q)
  if (Object.values(lookup).includes(3)) {
    console.log("case 2");
    const entries = Object.entries(lookup);
    const p = +entries.find(([key, value]) => value === 3)[0];
    const q = +entries.find(([key, value]) => value === 1)[0];
    return (10 * p + q) ** 2;
  }

  // case 3 : 주사위가 두 개씩 같은 값이 나오고 나온 숫자를 각각 p,q(p !== q)
  if (Object.values(lookup)[0] === 2 && Object.values(lookup)[1] === 2) {
    console.log("case 3");
    const [p, q] = Object.keys(lookup).map((v) => Number(v));
    return (p + q) * Math.abs(p - q);
  }

  // case 4 : 어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 p와 다른 q,r 이라면
  if (Object.values(lookup).length === 3) {
    // [2, 1, 1] 무조건
    console.log("case 4");
    const [q, r] = Object.entries(lookup)
      .filter((entry) => entry[1] === 1)
      .map((entry) => +entry[0]);
    return q * r;
  }

  // case 5 : 네 주사위에 적힌 숫자가 모두 다르다면
  console.log("case 5");
  if (temp.length === new Set(temp).size) return Math.min(...temp);
}
