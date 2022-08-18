function solution(board, moves) {
  let answer = 0;

  let n = board.length;

  let temp = Array.from({ length: n }, (v, i) =>
    board
      .map((arr) => arr[i])
      .reverse()
      .filter((v) => v !== 0)
  );
  // console.log(temp)

  let bucket = [];

  moves.forEach((move) => {
    const currentDoll = temp[move - 1].pop();

    if (!currentDoll) return;
    else if (bucket[bucket.length - 1] === currentDoll) {
      answer += 2;
      bucket.pop();
    } else {
      bucket.push(currentDoll);
    }
  });

  return answer;
}
