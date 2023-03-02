function solution(my_string) {
  const regex = /[a-z|A-Z]/g;
  const splited = my_string.split(regex);
  return splited.filter((v) => v !== "").reduce((a, c) => a + Number(c), 0);
}
