function countUniqueValues(arr) {
  // add whatever parameters you deem necessary - good luck!
  if (arr.length < 1) return 0;

  let i = 0,
    j = 0;

  while (j < arr.length) {
    if (arr[i] === arr[j]) {
      j++;
    } else {
      arr[++i] = arr[j];
    }
  }

  return i + 1;
}

console.log(countUniqueValues([1, 2, 2, 3, 3, 4])); // 4
