function solution(str1, str2) {
  const getCount = (str) => {
    return [...str]
      .slice(0, -1)
      .map((v, i) => (v + str[i + 1]).toLowerCase())
      .filter((v) => !/[^a-z]/g.test(v))
      .reduce((acc, v) => {
        if (acc[v]) {
          acc[v]++;
        } else {
          acc[v] = 1;
        }
        return acc;
      }, {});
  };

  const A = getCount(str1);
  const B = getCount(str2);

  const keys = new Set([...Object.keys(A), ...Object.keys(B)]);
  console.log(keys);
  let intersection = 0; // 교집합
  let union = 0; // 합집합

  for (const key of keys) {
    if (A[key] && B[key]) {
      intersection += Math.min(A[key], B[key]);
      union += Math.max(A[key], B[key]);
    } else if (A[key]) {
      union += A[key];
    } else if (B[key]) {
      union += B[key];
    }
  }

  return !intersection && !union
    ? 65536
    : Math.floor((intersection / union) * 65536);
}
