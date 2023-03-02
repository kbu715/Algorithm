function solution(hp) {
  let answer = 0;

  let dividers = [5, 3, 1];

  for (let i = 0; i < dividers.length; i++) {
    answer += Math.floor(hp / dividers[i]);
    hp = hp % dividers[i];
  }

  return answer;
}
