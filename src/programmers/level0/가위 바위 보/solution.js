function solution(rsp) {
  var answer = "";

  const arr = rsp.split("").map((v) => getWinningCase(v));

  answer = arr.join("");

  return answer;
}

function getWinningCase(c) {
  switch (c) {
    case "2":
      return "0";
    case "0":
      return "5";
    case "5":
      return "2";
  }
}
