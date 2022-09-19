function solution(skill, skill_trees) {
  let answer = 0;
  for (const tree of skill_trees) {
    let arr = tree
      .split("")
      .filter((x) => skill.includes(x))
      .map((c) => skill.indexOf(c));

    if (isPossible(arr)) answer += 1;
  }
  return answer;
}

function isPossible(arr) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] !== i) return false;
  }
  return true;
}
