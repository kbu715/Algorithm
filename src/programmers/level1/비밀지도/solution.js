function solution(n, arr1, arr2) {
  let answer = [];

  let temp = Array.from({ length: n }, () => Array(n).fill(0));

  function getBinary(num) {
    let decimal = num;
    let bStr = "";
    while (decimal > 0) {
      bStr = (decimal % 2) + bStr;
      decimal = Math.floor(decimal / 2);
    }

    bStr = decimal + bStr;

    if (bStr.length > n) {
      bStr = bStr.slice(1);
    } else if (bStr.length < n) {
      bStr = "0".repeat(n - bStr.length) + bStr;
    }

    return bStr;
  }

  let temp1 = arr1.map((v) =>
    getBinary(v)
      .split("")
      .map((v) => +v)
  );
  let temp2 = arr2.map((v) =>
    getBinary(v)
      .split("")
      .map((v) => +v)
  );

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      temp[i][j] = temp1[i][j] === 0 && temp2[i][j] === 0 ? " " : "#";
    }
  }

  answer = temp.map((arr) => arr.join(""));

  return answer;
}
