function solution(babbling) {
  let answer = 0;
  const p = ["aya", "ye", "woo", "ma"];

  babbling.forEach((word) => {
    for (let i = 0; i < p.length; i++) {
      if (word.includes(p[i].repeat(2))) {
        // 2번 반복되면 (=2번 이상 반복되면) break
        break;
      }

      word = word.split(p[i]).join("/");
    }

    console.log(word);
    if (word.split("/").join("") === "") answer++;
  });

  return answer;
}
