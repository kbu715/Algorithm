// Binary Search

function search(array, val) {
  let min = 0;
  let max = array.length - 1;

  while (min <= max) {
    let middle = Math.floor((min + max) / 2);
    let currentElem = array[middle];

    if (currentElem < val) {
      min = middle + 1;
    } else if (currentElem > val) {
      max = middle - 1;
    } else {
      return middle;
    }
  }
  return -1;
}
