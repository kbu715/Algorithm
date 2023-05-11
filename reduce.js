//reduce를 사용해서 배열의 합을 구하는 함수를 작성해주세요.
const nums = [1, 2, 3, 4, 5];

function getSum(arr) {
  const result = arr.reduce((a, c) => a + c, 0);
  return result;
}

// console.log(getSum(nums));

// const callback = (acc = this[0], curr = this[1], currIndex, this) => {}
// Array.prototype.reduce(callback);

//reduce를 구현해주세요.
// function reduce(callback, initialValue, arr) {
//   let sum = initialValue || arr[0];

//   for (const v of arr) {
//     sum = callback(sum, v);
//   }

//   return sum;
// }

// custom 함수를 만든다
Array.prototype.myReduce = function (callback, initialValue) {
  let sum = initialValue || this[0];
  const initialIdx = initialValue ? 0 : 1;

  for (let idx = initialIdx; idx < this.length; idx++) {
    sum = callback(sum, this[idx], idx, this);
  }

  return sum;
};

console.log(nums.myReduce((a, c) => a + c, 0));

const strs = ["1", "2", "3"];

const objs = [
  {
    a: 1,
  },
  {
    b: 1,
  },
  {
    c: 1,
  },
];

console.log(strs.myReduce((a, c, i) => a + c + i, "result: "));

const people = [
  { name: "Mike", score: 21 },
  { name: "Tracy", score: 23 },
  { name: "Noah", score: 29 },
];

// {
//   Mike: "1/3 score: 21",
//   Tracy: "2/3 score: 23",
//   Noah: "3/3 score: 29"
// }

console.log(
  people.myReduce(
    (a, c, idx, arr) => ({
      ...a,
      [c.name]: `${idx + 1}/${arr.length} score: ${c.score}`,
    }),
    {}
  )
);
