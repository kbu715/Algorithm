function selectionSort(arr) {
  for (let i = 0; i < arr.length; i++) {
    let lowest = i;

    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[lowest]) {
        lowest = j;
      }
    }

    // SWAP!! But, the “minimum” is not the value (index) you initially began with,
    if (i !== lowest) {
      const temp = arr[i];
      arr[i] = arr[lowest];
      arr[lowest] = temp;
    }
  }
  return arr;
}

console.log(selectionSort([3, 2, 5, 1, 4, 6]));
