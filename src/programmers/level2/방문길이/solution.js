function solution(dirs) {
  let answer = 0;

  const dir = dirs.split("");
  let checked = [];

  let pos = [0, 0];
  for (const x of dir) {
    pos = move(x, pos);
  }

  function move(ch, pos) {
    let start = [...pos];
    switch (ch) {
      case "L":
        pos[0] -= 1;
        break;
      case "R":
        pos[0] += 1;
        break;
      case "U":
        pos[1] += 1;
        break;
      case "D":
        pos[1] -= 1;
        break;
    }

    if (pos[0] < -5 || pos[0] > 5 || pos[1] < -5 || pos[1] > 5) return start;

    if (!checked.includes(`${start[0]}${start[1]}${ch}`)) {
      answer++;
    }
    checked.push(`${start[0]}${start[1]}${ch}`);
    checked.push(`${pos[0]}${pos[1]}${getOpposite(ch)}`);
    return pos;
  }

  function getOpposite(ch) {
    switch (ch) {
      case "L":
        return "R";

      case "R":
        return "L";

      case "U":
        return "D";

      case "D":
        return "U";

      default:
        break;
    }
  }

  console.log(checked);
  return answer;
}
