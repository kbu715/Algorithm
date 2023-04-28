// Divide and Conquer - countZeroes
// Given an array of 1s and 0s which has all 1s first followed by all 0s, write a function called countZeroes, which returns the number of zeroes in the array.

// countZeroes([1,1,1,1,0,0]) // 2
// countZeroes([1,0,0,0,0]) // 4
// countZeroes([0,0,0]) // 3
// countZeroes([1,1,1,1]) // 0
// Time Complexity - O(log n)

// Iterative solution
function countZeroes(arr) {
  let min = 0;
  let max = arr.length - 1;
  while (min <= max) {
    let middle = Math.floor((min + max) / 2);

    // If middle is 1 and the index after it is 1, bring the min up
    if (arr[middle] === 1 && arr[middle + 1] === 1) {
      min = middle + 1;
    }
    // If middle is 0 and the index before it is 0, bring the max down
    else if (arr[middle] === 0 && arr[middle - 1] === 0) {
      max = middle - 1;
    }
    // If middle is 1 and the index after it is 0, return the number of 0s
    else if (arr[middle] === 1 && arr[middle + 1] === 0) {
      return arr.length - (middle + 1);
    }
    // If middle is 0 and the index before it is 1, return the number of 0s
    else if (arr[middle] === 0 && arr[middle - 1] === 1) {
      return arr.length - middle;
    }
    // If middle is 0, that means we reached the end of our divide and counquer, and all indexes are 0s
    else if (middle === 0) {
      return arr.length;
    }
  }
}
