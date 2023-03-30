function insertionSort(array) {
  for (let i = 1; i < array.length; i++) {
    const current = array[i];
    let j;
    for (j = i - 1; j >= 0 && arr[j] > current; j--) {
      array[j + 1] = array[j];
    }
    array[j + 1] = current;
  }
  return array;
}

insertionSort([2, 1, 9, 76, 4]);
