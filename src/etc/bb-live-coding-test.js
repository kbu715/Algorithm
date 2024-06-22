/*
Given an array of integers, return an array of integers such that the value 
at index i of the output is the product of everything in the input except the 
input value at index i. An empty list should return []. 
A list of length 1 should return [1] no matter what the input element is.

Example:
product_exclusion([2, 3, 4, 5])  # => [60, 40, 30, 24]
*/

// O(n) 시간 복잡도
function solution(nums) {
  const left = new Array(nums.length).fill(1); // 왼쪽 곱 목록 초기화
  const right = new Array(nums.length).fill(1); // 오른쪽 곱 목록 초기화

  // 왼쪽 곱 목록 계산
  for (let i = 1; i < nums.length; i++) {
    // 0 -> 1 -> 2 순
    left[i] = left[i - 1] * nums[i - 1];
  }

  // 오른쪽 곱 목록 계산
  for (let i = nums.length - 2; i >= 0; i--) {
    // 2 -> 1 -> 0 순
    right[i] = right[i + 1] * nums[i + 1];
  }

  // 최종 결과 계산
  const result = left.map((value, index) => value * right[index]);

  return result;
}

// 사용 예시:
const input = [2, 3, 4, 5];
const result = solution(input);
console.log(result); // 출력: [60, 40, 30, 24]

// -----------------------------------

function solution2(nums) {
  let numOfZeros = 0;
  let productWithoutZeroes = 1;

  // 첫 번째 루프: 0의 개수를 세고, 0이 아닌 요소들의 곱을 계산합니다.
  for (let num of nums) {
    if (num === 0) {
      numOfZeros++;
    } else {
      productWithoutZeroes *= num;
    }
  }

  // 결과 배열을 초기화합니다.
  const result = new Array(nums.length).fill(0);

  // 0이 두 개 이상인 경우
  if (numOfZeros > 1) {
    return result; // 모든 요소가 0인 배열을 반환합니다.
  }

  // 0이 하나인 경우
  if (numOfZeros === 1) {
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] === 0) {
        result[i] = productWithoutZeroes;
      }
    }
    return result;
  }

  // 0이 없는 경우
  for (let i = 0; i < nums.length; i++) {
    result[i] = productWithoutZeroes / nums[i];
  }

  return result;
}

// 사용 예시:
const inputs = [2, 3, 4, 5];
const resultArray = solution2(inputs);
console.log(resultArray); // 출력: [60, 40, 30, 24]

const inputsWithZero = [2, 3, 0, 5];
const resultArrayWithZero = solution2(inputsWithZero);
console.log(resultArrayWithZero); // 출력: [0, 0, 30, 0]

const inputsWithMultipleZeros = [2, 0, 4, 0];
const resultArrayWithMultipleZeros = solution2(inputsWithMultipleZeros);
console.log(resultArrayWithMultipleZeros); // 출력: [0, 0, 0, 0]
