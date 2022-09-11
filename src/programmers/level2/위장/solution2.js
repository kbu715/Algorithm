function solution(clothes) {
  return (
    Object.values(
      clothes.reduce((obj, cloth) => {
        obj[cloth[1]] = obj[cloth[1]] ? obj[cloth[1]] + 1 : 1;
        return obj;
      }, {})
    ).reduce((a, c) => a * (c + 1), 1) - 1
  );
}
