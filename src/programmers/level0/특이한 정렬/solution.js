// function solution(numlist, n) {
//   function getAbs(v) {
//     return Math.abs(n - v);
//   }

//   numlist
//     .sort((a, b) => getAbs(a) - getAbs(b))
//     .sort((a, b) => {
//       if (getAbs(a) === getAbs(b)) {
//         return b - a;
//       }
//     });

//   return numlist;
// }

/*
반례 : solution([10,9,8,7,6,5,4,3,2,1,11],6);
기대값 [6, 7, 5, 8, 4, 9, 3, 10, 2, 11, 1]
리턴값 :[ 6, 5, 7, 4, 8, 3, 9, 2, 10, 11, 1 ]
*/

function solution(numlist, n) {
  return numlist.sort((a, b) => Math.abs(a - n) - Math.abs(b - n) || b - a);
}
