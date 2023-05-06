function solution(dart) {
  const numStack = [];

  const numArray = dart
    .replace(/[^0-9]/g, " ")
    .split(" ")
    .filter((v) => v);
  const strArray = dart
    .replace(/[0-9]/g, "")
    .split("")
    .filter((v) => v.trim());

  while (numArray.length) {
    let num = numArray.shift();
    let str = strArray.shift();

    num = num ** { S: 1, D: 2, T: 3 }[str];

    if (["*", "#"].includes(strArray[0])) {
      str = strArray.shift();

      num *= "*" == str ? 2 : -1;

      if ("*" == str && numStack.length) {
        numStack[numStack.length - 1] *= 2;
      }
    }

    numStack.push(num);
  }

  return numStack.reduce((acc, v) => acc + v, 0);
}
