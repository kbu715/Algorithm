function solution(ingredient) {
  let answer = 0;
  let stack = [];

  for (let i = 0; i < ingredient.length; ++i) {
    stack.push(ingredient[i]);

    if (stack.length < 4) continue;

    // stack.length >= 4
    if (
      stack.at(-4) === 1 &&
      stack.at(-3) === 2 &&
      stack.at(-2) === 3 &&
      stack.at(-1) === 1
    ) {
      stack.splice(-4, 4); // -4 인덱스 지점부터 4개 삭제
      answer++;
    }
  }

  return answer;
}
