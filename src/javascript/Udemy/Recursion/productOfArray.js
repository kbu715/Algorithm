/*
productOfArray
Write a function called productOfArray which takes in an array of numbers and returns the product of them all.
*/

// function productOfArray(arr) {
//   let result = 1;
//   function helper(helperInput) {
//     if (helperInput.length === 0) return 1;
//     return helperInput[0] * helper(helperInput.slice(1));
//   }

//   result = result * helper(arr);

//   return result;
// }

function productOfArray(arr) {
  if (arr.length === 0) {
    return 1;
  }
  return arr[0] * productOfArray(arr.slice(1));
}
