function solution(arr, k) {
  let result = Array.from(new Set(arr)).slice(0, k);

  if (result.length < k) {
    const temp = new Array(k - result.length).fill(-1);
    result = [...result, ...temp];
    return result;
  }
  return result;
}
