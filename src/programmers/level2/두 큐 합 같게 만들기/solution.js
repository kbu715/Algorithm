// 투포인터
function solution(queue1, queue2) {
  let sum1 = getSum(queue1);
  let sum2 = getSum(queue2);
  const target = (sum1 + sum2) / 2;

  let lt = 0,
    rt = queue1.length;
  const end = (queue1.length + queue2.length) * 2; // 최대 반복횟수

  const queue = [...queue1, ...queue2];

  for (let count = 0; count < end; count++) {
    if (sum1 === target) return count;

    if (sum1 > target) sum1 -= queue[lt++];
    else sum1 += queue[rt++];
  }

  return -1;
}

function getSum(queue) {
  return queue.reduce((a, c) => a + c, 0);
}
