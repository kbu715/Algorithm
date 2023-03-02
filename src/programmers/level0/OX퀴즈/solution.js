function solution(quiz) {
  let answer = [];

  const quizArr = quiz.map((one) => one.split(" "));

  for (const q of quizArr) {
    const [X, OP, Y, _, Z] = q;
    let result = "";

    if (OP === "+") {
      result = Number(X) + Number(Y) === Number(Z) ? "O" : "X";
    } else {
      result = Number(X) - Number(Y) === Number(Z) ? "O" : "X";
    }

    answer.push(result);
  }

  return answer;
}
