function solution(name, yearning, photo) {
  let answer = [];

  const lookup = {};

  let i = 0;
  for (const x of name) {
    lookup[x] = yearning[i];
    i++;
  }

  answer = photo.map((people) =>
    people.map((name) => lookup[name] || 0).reduce((a, c) => a + c, 0)
  );

  return answer;
}
