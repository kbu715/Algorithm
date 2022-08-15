function solution(a, b) {
  let answer = "";

  let months = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

  let week = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"];

  let totalDays = 0;

  for (let i = 0; i < a - 1; i++) {
    totalDays += months[i];
  }

  totalDays += b;

  answer = week[totalDays % 7];

  return answer;
}
