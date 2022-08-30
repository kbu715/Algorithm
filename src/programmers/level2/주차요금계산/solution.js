function solution(fees, records) {
  var answer = [];

  // 기본시간, 기본요금, 단위시간, 단위요금
  const [defaultTime, defaultFee, unitTime, unitFee] = fees;

  let recordList = records
    .map((record) => record.split(" "))
    .sort((a, b) => Number(a[1]) - Number(b[1])); // 차 번호로 정렬
  recordList = recordList.map((record) => [
    getMinutes(record[0]),
    record[1],
    record[2],
  ]);

  const set = new Set(recordList.map((v) => v[1]));

  const result = Array.from(set)
    .map((carNum) => {
      return recordList
        .filter((record) => record[1] === carNum)
        .reduce((a, b) => {
          return b[2] === "IN" ? a - Number(b[0]) : a + Number(b[0]);
        }, 0);
    })
    .map((value) => {
      if (value === -1439) return 1439; // 00:00 'IN' 인 경우
      else if (value < 0) return value + 1439; // 'OUT'을 끝내 하지 못한 경우
      return value; // 일반적인 IN-OUT을 한 경우
    });

  answer = result.map((minutes) => {
    return minutes <= defaultTime
      ? defaultFee
      : defaultFee + Math.ceil((minutes - defaultTime) / unitTime) * unitFee;
  });

  return answer;
}

function getMinutes(str) {
  const [hh, mm] = str.split(":").map((value) => +value);

  if (hh === 0 && mm === 0) return 1439; // 23:59
  else if (hh === 0) return mm;

  return hh * 60 + mm;
}
