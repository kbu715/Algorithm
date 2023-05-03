function solution(my_string, queries) {
  let arr = my_string.split("");
  queries.forEach((q) => {
    const [s, e] = q;
    arr = [
      ...arr.slice(0, s),
      ...arr.slice(s, e + 1).reverse(),
      ...arr.slice(e + 1),
    ];
  });
  return arr.join("");
}
