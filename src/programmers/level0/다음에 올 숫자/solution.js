// function solution(common) {
//   const len = common.length;
//   const isGeometric = common[1] - common[0] !== common[2] - common[1]; // 등비수열인지 등차수열인지

//   let calcNum = isGeometric ? common[1] / common[0] : common[1] - common[0];

//   if (isGeometric) return common[len - 1] * calcNum;

//   return common[len - 1] + calcNum;
// }

function solution(common) {
  if (common[1] - common[0] == common[2] - common[1]) {
    return common.pop() + common[1] - common[0];
  } else {
    return (common.pop() * common[1]) / common[0];
  }
}
