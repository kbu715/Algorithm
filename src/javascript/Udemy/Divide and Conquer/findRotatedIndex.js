function findRotatedIndex(arr, target) {
  let pivotIndex;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i + 1] < arr[i]) {
      pivotIndex = i + 1;
      break;
    }
  }
  let start = 0;
  let end = arr.length - 1;
  let middle = pivotIndex; // 정렬이 분리되는 순간 지점

  // 이진 검색
  while (arr[middle] !== target && start <= end) {
    if (arr[middle] === target) return middle;
    // pivotIndex 보다 하나 작은, 가장 큰수보다 작거나 같고 나머지 반 쪽의 모든 수 보다는 클 때
    if (arr[middle - 1] >= target && arr[end] < target) end = middle - 1;
    else start = middle + 1;
    middle = Math.floor((start + end) / 2);
  }
  return arr[middle] === target ? middle : -1;
}

// findRotatedIndex([6, 7, 8, 9, 1, 2, 3, 4], 3) // 6
