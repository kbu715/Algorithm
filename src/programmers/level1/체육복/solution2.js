function solution(n, lost, reserve) {
  var answer = 0;

  let filteredReserve = reserve
    .filter((v) => !lost.includes(v))
    .sort((a, b) => a - b);
  let filteredLost = lost
    .filter((v) => !reserve.includes(v))
    .sort((a, b) => a - b);

  const result = filteredLost.filter((v) => {
    let index;
    if (filteredReserve.includes(v - 1)) {
      index = filteredReserve.indexOf(v - 1);
      filteredReserve.splice(index, 1);
      return false;
    } else if (filteredReserve.includes(v + 1)) {
      index = filteredReserve.indexOf(v + 1);
      filteredReserve.splice(index, 1);
      return false;
    } else {
      return true;
    }
  });

  answer = n - result.length;

  return answer;
}
