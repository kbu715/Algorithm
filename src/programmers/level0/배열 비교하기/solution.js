function solution(arr1, arr2) {
  if (arr1.length < arr2.length) return -1;
  else if (arr1.length > arr2.length) return 1;
  else {
    if (getTotal(arr1) > getTotal(arr2)) return 1;
    else if (getTotal(arr1) < getTotal(arr2)) return -1;
    else return 0;
  }
}

function getTotal(arr) {
  return arr.reduce((a, c) => a + c, 0);
}
