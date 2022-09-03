function solution(priorities, location) {
  let answer = 0;

  // [A, 2]
  let queue = [...priorities.map((v, i) => [String.fromCharCode(65 + i), v])];
  let alphabet = queue[location][0]; // C

  let temp = []; // 프린터 대기 목록

  while (queue.length > 0) {
    const cur = queue[0];
    const priorities = queue.map((v) => v[1]);

    if (hasHigherPriority(cur[1], priorities)) {
      queue.push(cur);
    } else {
      temp.push(cur);
    }
    queue.splice(0, 1);
  }

  answer = temp.findIndex((v) => v[0] === alphabet) + 1;

  return answer;
}

function hasHigherPriority(cur, priorities) {
  for (const x of priorities) {
    if (x > cur) return true;
  }
  return false;
}
