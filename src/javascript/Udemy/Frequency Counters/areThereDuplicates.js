/*
Implement a function called, areThereDuplicates which accepts a variable number of arguments, and checks whether there are any duplicates among the arguments passed in.  You can solve this using the frequency counter pattern OR the multiple pointers pattern.

Examples:

areThereDuplicates(1, 2, 3) // false
areThereDuplicates(1, 2, 2) // true 
areThereDuplicates('a', 'b', 'c', 'a') // true 
Restrictions:

Time - O(n)

Space - O(n)

Bonus:

Time - O(n log n)

Space - O(1)

*/

// function areThereDuplicates(...args) {
//   const lookup = {};

//   for (const x of args) {
//     lookup[x] ? (lookup[x] += 1) : (lookup[x] = 1);
//   }

//   if (Object.values(lookup).findIndex((v) => v >= 2) === -1) return false;

//   return true;
// }

function areThereDuplicates() {
  let lookup = {};
  for (let val in arguments) {
    lookup[arguments[val]] = (lookup[arguments[val]] || 0) + 1;
  }
  for (let key in lookup) {
    if (lookup[key] > 1) return true;
  }
  return false;
}
