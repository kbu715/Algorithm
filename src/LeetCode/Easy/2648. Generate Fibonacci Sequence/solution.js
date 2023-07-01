// 2648. Generate Fibonacci Sequence
/**
 * @return {Generator<number>}
 */
var fibGenerator = function* () {
  const MAX_CALL_COUNT = 50;
  let a = 0;
  let b = 1;

  yield a;
  yield b;

  for (let i = 2; i <= MAX_CALL_COUNT; i++) {
    let temp = a + b;
    yield temp;
    a = b;
    b = temp;
  }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
