process.stdin.setEncoding("utf8");
process.stdin.on("data", (data) => {
  const n = data.split(" ");
  const a = Number(n[0]),
    b = Number(n[1]);
  let arr = Array.from({ length: b }, () => Array(a).fill("*").join(""));

  arr = arr.join("\n");

  console.log(arr);
});
