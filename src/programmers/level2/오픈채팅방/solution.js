function solution(record) {
  let answer = [];
  let map = new Map();

  // 결국 누가 남아있는지가 중요!
  for (i = 0; i < record.length; i++) {
    const [command, id, nick] = record[i].split(" ");

    if (!map.get(id)) {
      map.set(id, nick);
    } else if (command == "Change" || command == "Enter") {
      map.set(id, nick);
    }
  }

  for (i = 0; i < record.length; i++) {
    const [command, id] = record[i].split(" ");
    if (command == "Enter") {
      answer.push(`${map.get(id)}님이 들어왔습니다.`);
    }
    if (command == "Leave") {
      answer.push(`${map.get(id)}님이 나갔습니다.`);
    }
  }
  return answer;
}
