/*
reverse
Write a recursive function called reverse which accepts a string and returns a new string in reverse.
*/

// function reverse(str) {
//   // add whatever parameters you deem necessary - good luck!

//   function helper(helperInput) {
//     if (helperInput.length === 0) return "";

//     return (
//       helperInput[helperInput.length - 1] +
//       helper(helperInput.slice(0, helperInput.length - 1))
//     );
//   }

//   return helper(str);
// }

// reverse('awesome') // 'emosewa'
// reverse('rithmschool') // 'loohcsmhtir'

function reverse(str) {
  if (str.length <= 1) return str;
  return reverse(str.slice(1)) + str[0];
}
