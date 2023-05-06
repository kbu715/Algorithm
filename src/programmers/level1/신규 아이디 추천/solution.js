function solution(new_id) {
  let answer = new_id;
  answer = answer.toLowerCase();

  answer = answer.replace(/[^a-z0-9\-\_\.]/gi, "");

  answer = answer.replace(/[.]+/gi, ".");

  while (answer[0] === ".") {
    answer = answer.substring(1);
  }
  while (answer[answer.length - 1] === ".") {
    answer = answer.substring(0, answer.length - 1);
  }

  if (answer === "") answer = "a";

  if (answer.length >= 16) {
    answer = answer.substring(0, 15);
  }
  while (answer[answer.length - 1] === ".") {
    answer = answer.substring(0, answer.length - 1);
  }

  if (answer.length <= 2) {
    answer = answer.padEnd(3, answer[answer.length - 1]);
  }
  return answer;
}
