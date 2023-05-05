function solution(join_date, resign_date, holidays) {
  const join_year = join_date.split("/")[0];
  const resign_year = resign_date.split("/")[0];

  // 주어진 문자열을 Date 객체로 변환
  join_date = new Date(join_date.split(" ")[0]);
  resign_date = new Date(resign_date);

  // 공휴일 설정
  let temp = [];
  holidays.forEach((holiday) => {
    for (let i = +join_year; i <= +resign_year; i++) {
      temp.push(new Date(`${i}/${holiday}`));
    }
  });
  holidays = temp;

  //   console.log(holidays);

  // 공휴일 제외 근무일 계산
  let answer = 0;
  let current_date = join_date;
  while (current_date <= resign_date) {
    // 주말이 아니거나 공휴일에 포함되지 않는 경우 +1
    if (
      !isWeekend(current_date) &&
      !holidays.some(
        (holiday) =>
          holiday.getMonth() === current_date.getMonth() &&
          holiday.getDate() === current_date.getDate()
      )
    ) {
      answer++;
    }
    // 다음날
    current_date.setDate(current_date.getDate() + 1);
  }

  return answer;
}

function isLeapYear(year) {
  if (year % 400 === 0 || (year % 4 === 0 && year % 100 !== 0)) {
    return true;
  }
  return false;
}

function isWeekend(date) {
  const dayOfWeek = new Date(date).getDay();
  return dayOfWeek === 6 || dayOfWeek === 0;
}
