function solution(name) {
  const arr = [...name];
  const indexes = arr
    .map((v, i) => (v !== "A" ? i : v))
    .filter((v) => v && typeof v === "number");
  let move = 0;
  let position = 0;
  let back = false;
  const moveTopAndBottom = (c) =>
    c !== "A"
      ? Math.min(Math.abs(c.charCodeAt() - 91), Math.abs(c.charCodeAt() - 65))
      : 0;
  move += moveTopAndBottom(arr[position]);
  while (indexes.length) {
    const left = back
      ? position - indexes[indexes.length - 1]
      : position - indexes[indexes.length - 1] + arr.length;
    const right = indexes[0] - position;
    if (back || (!back && left < right)) {
      back = true;
      move += left;
      position = indexes[indexes.length - 1];
      indexes.pop();
    } else {
      move += right;
      position = indexes[0];
      indexes.shift();
    }
    move += moveTopAndBottom(arr[position]);
  }
  return move;
}
