/*
isPalindrome
Write a recursive function called isPalindrome which returns true if the string passed to it is a palindrome (reads the same forward and backward). Otherwise it returns false.
*/

// isPalindrome('awesome') // false
// isPalindrome('foobar') // false
// isPalindrome('tacocat') // true
// isPalindrome('amanaplanacanalpanama') // true
// isPalindrome('amanaplanacanalpandemonium') // false

// function isPalindrome(str) {
//   // add whatever parameters you deem necessary - good luck!

//   function helper(helperInput) {
//     if (helperInput.length === 0) return "";

//     return (
//       helperInput[helperInput.length - 1] +
//       helper(helperInput.slice(0, helperInput.length - 1))
//     );
//   }

//   if (str !== helper(str)) return false;
//   return true;
// }

function isPalindrome(str) {
  if (str.length === 1) return true;
  if (str.length === 2) return str[0] === str[1];
  if (str[0] === str.slice(-1)) return isPalindrome(str.slice(1, -1));
  return false;
}
