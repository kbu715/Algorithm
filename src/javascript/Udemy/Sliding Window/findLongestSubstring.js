/*
Write a function called findLongestSubstring, which accepts a string and returns the length of the longest substring with all distinct characters.

findLongestSubstring('') // 0
findLongestSubstring('rithmschool') // 7
findLongestSubstring('thisisawesome') // 6
findLongestSubstring('thecatinthehat') // 7
findLongestSubstring('bbbbbb') // 1
findLongestSubstring('longestsubstring') // 8
findLongestSubstring('thisishowwedoit') // 6
Time Complexity - O(n)
*/

function findLongestSubstring(str) {
  if (str.length === 0) return 0;

  let start = 0;
  let end = 1;

  let longestLen = -Infinity;
  let temp = str[start];

  while (start < str.length) {
    if (str[start] !== str[end]) {
      temp += str[end];
      end++;
    } else {
      longestLen = Math.max(longestLen, end - start);
      start++;
    }
  }

  return longestLen;
}
