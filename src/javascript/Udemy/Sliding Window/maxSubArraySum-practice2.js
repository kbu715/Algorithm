function maxSubarraySum(arr, num) {
  if (num > arr.length) return null;

  let maxSum = 0;
  let tempSum = arr.slice(0, num).reduce((a, c) => a + c, 0);

  for (let i = num; i < arr.length; i++) {
    tempSum = tempSum - arr[i - num] + arr[i];

    maxSum = Math.max(maxSum, tempSum);
  }

  return maxSum;
}
