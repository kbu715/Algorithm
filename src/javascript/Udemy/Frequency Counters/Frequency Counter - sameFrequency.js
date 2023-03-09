// function sameFrequency(a, b) {
//   // good luck. Add any arguments you deem necessary.
//   const strA = String(a);
//   const strB = String(b);

//   if (strA.length !== strB.length) return false;

//   const lookup = {};

//   for (let i = 0; i < strA.length; i++) {
//     lookup[strA[i]] = (lookup[strA[i]] && lookup[strA[i]] + 1) || 1;
//   }

//   for (let j = 0; j < strB.length; j++) {
//     const letter = strB[j];
//     if (!lookup[letter]) {
//       return false;
//     } else {
//       lookup[letter] -= 1;
//     }
//   }

//   return true;
// }

function sameFrequency(num1, num2) {
  let strNum1 = num1.toString();
  let strNum2 = num2.toString();
  if (strNum1.length !== strNum2.length) return false;

  let countNum1 = {};
  let countNum2 = {};

  for (let i = 0; i < strNum1.length; i++) {
    countNum1[strNum1[i]] = (countNum1[strNum1[i]] || 0) + 1;
  }

  for (let j = 0; j < strNum2.length; j++) {
    countNum2[strNum2[j]] = (countNum2[strNum2[j]] || 0) + 1;
  }

  for (let key in countNum1) {
    if (countNum1[key] !== countNum2[key]) return false;
  }

  return true;
}
