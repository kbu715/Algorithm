function solution(numbers) {
  let answer = 0;

  const splited = numbers.split("");

  let temp = [];
  for (let i = 1; i <= splited.length; i++) {
    temp = [...temp, ...getPermutation(splited, i)];
  }

  answer = new Set(
    temp
      .map((arr) => +arr.reduce((a, c) => a + c, ""))
      .filter((v) => isPrime(v))
  ).size;

  return answer;
}

// 소수 찾기

function isPrime(n) {
  let sqrtN = Math.sqrt(n);
  for (let i = 2; i <= sqrtN; i++)
    if (n % i === 0) {
      return false;
    }
  return n > 1;
}

// 순열

function getPermutation(arr, selectNum) {
  const result = [];
  if (selectNum === 1) return arr.map((v) => [v]);

  arr.forEach((fixed, index, origin) => {
    // 해당 fixed를 제외한 나머지 배열
    const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
    // 나머지에 대해서 순열을 구한다.
    const permutations = getPermutation(rest, selectNum - 1);
    //  돌아온 순열에 fixed값 붙이기
    const attached = permutations.map((perm) => [fixed, ...perm]);
    // 배열 spread syntax 로 모두다 push
    result.push(...attached);
  });

  return result;
}
