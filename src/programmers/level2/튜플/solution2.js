function solution(s) {
  const parsed = JSON.parse(s.replace(/{/g, "[").replace(/}/g, "]"));
  console.log(parsed);
  return parsed
    .sort((a, b) => a.length - b.length)
    .reduce((arr, v, i) => {
      if (i) {
        // 첫번째 인덱스가 아닌 경우
        return arr.concat(v.filter((f) => !arr.includes(f)));
      }
      // 첫번째 인덱스인 경우 그냥 진행
      return v;
    }, []);
}
