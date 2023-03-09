/*
Write a function called averagePair. Given a sorted array of integers and a target average, determine if there is a pair of values in the array where the average of the pair equals the target average. There may be more than one pair that matches the average target.

Bonus Constraints:

Time: O(N)

Space: O(1)

Sample Input:

averagePair([1,2,3],2.5) // true
averagePair([1,3,3,5,6,7,10,12,19],8) // true
averagePair([-1,0,3,4,5,6], 4.1) // false
averagePair([],4) // false

*/
function averagePair(arr, avg) {
  if (arr.length === 0) return false;

  let start = 0;
  let end = arr.length - 1;

  while (start < end) {
    const num = arr[start] + arr[end] / 2;
    if (num === avg) return true;
    else if (num > avg) {
      end--;
    } else {
      start++;
    }
  }
  return false;
}

const result = averagePair([1, 2, 3], 2.5);

console.log(result);
